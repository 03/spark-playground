package au.com.sensis.bigdata.api.geoip;

import com.jayway.jsonpath.JsonPath;
import lombok.extern.log4j.Log4j;
import org.apache.commons.lang.StringUtils;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.URI;

/**
 *
 * http://freegeoip.net/json/40.143.25.1
 *
 {
 "ip": "40.143.25.1",
 "country_code": "US",
 "country_name": "United States",
 "region_code": "SC",
 "region_name": "South Carolina",
 "city": "Rock Hill",
 "zip_code": "29732",
 "time_zone": "America/New_York",
 "latitude": 34.966,
 "longitude": -81.0807,
 "metro_code": 517
 }

 */
@Log4j
public class GeoIpMapper implements Serializable {

    private final static String endPointSchema = "http";
    private final static String endPointHost = "freegeoip.net";
    private final static String endPointPath = "/json";

    private String inputContent(InputStream inputStream) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(inputStream));

        StringBuffer result = new StringBuffer();
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        return result.toString();
    }

    public String getResponse(String ip) throws Exception {

        URI uri = new URIBuilder().
                setScheme(endPointSchema).
                setHost(endPointHost).
                setPath(endPointPath + "/" + ip).
                build();
        HttpGet request = new HttpGet(uri);

        String event;
        CloseableHttpResponse response = HttpClients.createDefault().execute(request);
        StatusLine statusLine = response.getStatusLine();
        int status = statusLine.getStatusCode();
        if (status >= 200 && status < 300) {
            try {
                event = inputContent(response.getEntity().getContent());
            } finally {
                response.close();
            }
        } else {
            throw new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase());
        }
        return event;
    }

    public static void main(String[] args) throws Exception {
        GeoIpMapper api = new GeoIpMapper();

        String x = api.getResponse("40.143.25.1");
        System.out.println(x);

        if(StringUtils.isNotBlank(x)) {
            // List<String> displays = JsonPath.parse(x).read("$.results[?(@.granularity=='SUBURB')].address.display");
            String city = JsonPath.parse(x).read("$.city");
            Double latitude = JsonPath.parse(x).read("$.latitude");
            Double longitude = JsonPath.parse(x).read("$.longitude");
            System.out.println(city + " | " + latitude + " | " + longitude);
        }
    }
}

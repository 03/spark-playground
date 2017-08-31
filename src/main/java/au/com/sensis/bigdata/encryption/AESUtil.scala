package au.com.sensis.bigdata.encryption

/**
  * Created by orp on 13/07/17.
  *
  * Need to use jce_policy-8.zip, otherwise 'java.security.InvalidKeyException: Illegal key size' occurs
  */

import java.nio.charset.StandardCharsets
import java.security.{DigestException, MessageDigest}
import java.util.{Arrays, Base64}
import javax.crypto.Cipher
import javax.crypto.spec.{IvParameterSpec, SecretKeySpec}

object AESUtil extends Serializable {

  def main(args: Array[String]): Unit = {

    val secret: String = "hawking"
    val cipherText: String =
      "U2FsdGVkX1/RpARXPOAU6gjcGcrUaqmqhVSlPdZ7RimCyNxZKDgxDGlRbOAvIznA2LZTLtI/HfERKUNkqnLKKA=="
    println(decrypt(secret, cipherText))

    println("empty value: " + decrypt(secret, ""))
    println("null value: " + decrypt(secret, null))
  }

  def decrypt(secret: String, cipherText: String): String = {
    if(cipherText == null || cipherText.length==0) {
      return ""
    }
    val cipherData: Array[Byte] = Base64.getDecoder.decode(cipherText)
    val saltData: Array[Byte] = Arrays.copyOfRange(cipherData, 8, 16)
    val md5: MessageDigest = MessageDigest.getInstance("MD5")
    val keyAndIV: Array[Array[Byte]] = GenerateKeyAndIV(
      32,
      16,
      1,
      saltData,
      secret.getBytes(StandardCharsets.UTF_8),
      md5)
    val key: SecretKeySpec = new SecretKeySpec(keyAndIV(0), "AES")
    val iv: IvParameterSpec = new IvParameterSpec(keyAndIV(1))
    val encrypted: Array[Byte] =
      Arrays.copyOfRange(cipherData, 16, cipherData.length)
    val aesCBC: Cipher = Cipher.getInstance("AES/CBC/PKCS5Padding")
    aesCBC.init(Cipher.DECRYPT_MODE, key, iv)
    val decryptedData: Array[Byte] = aesCBC.doFinal(encrypted)
    val decryptedText: String =
      new String(decryptedData, StandardCharsets.UTF_8)
    decryptedText
  }

  def GenerateKeyAndIV(keyLength: Int,
                       ivLength: Int,
                       iterations: Int,
                       salt: Array[Byte],
                       password: Array[Byte],
                       md: MessageDigest): Array[Array[Byte]] = {
    val digestLength: Int = md.getDigestLength
    val requiredLength: Int = (keyLength + ivLength + digestLength - 1) / digestLength *
      digestLength
    val generatedData: Array[Byte] = Array.ofDim[Byte](requiredLength)
    var generatedLength: Int = 0
    try {
      md.reset()
      // Repeat process until sufficient data has been generated
      while (generatedLength < keyLength + ivLength) {
        // Digest data (last digest if available, password data, salt if available)
        if (generatedLength > 0)
          md.update(generatedData,
            generatedLength - digestLength,
            digestLength)
        md.update(password)
        if (salt != null) md.update(salt, 0, 8)
        md.digest(generatedData, generatedLength, digestLength)
        for (i <- 1 until iterations) {
          md.update(generatedData, generatedLength, digestLength)
          md.digest(generatedData, generatedLength, digestLength)
        }
        generatedLength += digestLength
      }
      // Copy key and IV into separate byte arrays
      val result: Array[Array[Byte]] = Array.ofDim[Byte](2, keyLength + ivLength)
      result(0) = Arrays.copyOfRange(generatedData, 0, keyLength)
      if (ivLength > 0)
        result(1) =
          Arrays.copyOfRange(generatedData, keyLength, keyLength + ivLength)
      result
    } catch {
      case e: DigestException => throw new RuntimeException(e)

    } finally // Clean out temporary data
      Arrays.fill(generatedData, 0.toByte)
  }

}

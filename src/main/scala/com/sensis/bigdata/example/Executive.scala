package society {
  package professional {
    class Executive {
      private[professional] var workDetails = null
      private[society] var friends = null
      private[this] var secrets : String = "*^&*^()HJJK"

      def help(another : Executive)(implicit secrets: String) {
        println(another.workDetails)
        //println(another.secrets) //ERROR
        println(secrets)
      }

      def getKey: String = {
        secrets
      }

    }

    object Executive {

      def main(args: Array[String]): Unit = {

        val executive = new Executive()
        executive.help(executive)(executive.getKey)

      }
    }
  }
}

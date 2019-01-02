package toninieto.sitemapgenerator

val validMainArgs = arrayListOf(
        "create-sitemap"
)


/**
 * Main module function. With this function starts all the application
 */
fun main(args : Array<String>) {

    var response = ""

    if ( args.isEmpty() || args[0] == "" || args[1] == "" || args[2] == "" ) {
        response = "ERROR: Any option was provided. The execution was interrupted"
        println(response)
        return
    }

    when (args[0]) {
        validMainArgs[0] -> { // create-sitemap
            val siteURL = args[1]
            val sitemapOutputFile = args[2]

            val sitemap = Sitemap()

            val sitemapCreated = sitemap.createSitemapFileFromSiteURL(siteURL, sitemapOutputFile).component1()
            if (sitemapCreated) {
                response = "The sitemap was created successfully"
            }
        }
    }
    println(response)
*
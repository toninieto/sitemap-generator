package toninieto.sitemapgenerator

import com.redfin.sitemapgenerator.WebSitemapGenerator
import java.io.File

class Sitemap {

    /**
     * Given a site URL and the sitemap output file path, we create the sitemap.xml file
     */
    fun createSitemapFileFromSiteURL(siteURL: String, outputDirectory: String): Pair<Boolean, String> {
        var result = false
        var response = "It was not possible to create the sitemap.xml file"

        val targetDirectory = File(outputDirectory)
        val sitemapCreated = WebSitemapGenerator.builder(siteURL, targetDirectory)
                            .fileNamePrefix("sitemap") // name of the generated sitemap
                            .gzip(false) //recommended - as it decreases the file's size significantly
                            .build()

        sitemapCreated.addUrl(siteURL)
        sitemapCreated.write()

        return Pair(result, response)
    }

}
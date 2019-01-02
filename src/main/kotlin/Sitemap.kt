package toninieto.sitemapgenerator

import com.redfin.sitemapgenerator.WebSitemapGenerator
import java.io.File

class Sitemap {

    /**
     * Given a site URL and the sitemap output file path, we create the sitemap.xml file
     */
    fun createSitemapFileFromSiteURL(siteURL: String, outputFilePath: String): Pair<Boolean, String> {
        var result = false
        var response = "It was not possible to create the sitemap.xml file"

        val targetDirectory = File(outputFilePath)
        val sitemapCreated = WebSitemapGenerator.builder("https://github.com/Codingpedia/podcastpedia", targetDirectory)
                            .fileNamePrefix("sitemap") // name of the generated sitemap
                            .gzip(true) //recommended - as it decreases the file's size significantly
                            .build()

        println("debug sitemapCreated: $sitemapCreated")

        return Pair(result, response)
    }

}
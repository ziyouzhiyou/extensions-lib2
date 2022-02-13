package com.ziyou.youman.source.online

import com.ziyou.youman.source.model.MangasPage
import com.ziyou.youman.source.model.Page
import com.ziyou.youman.source.model.SChapter
import com.ziyou.youman.source.model.SManga
import okhttp3.Response
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element

/**
 * A simple implementation for sources from a website using Jsoup, an HTML parser.
 */
@Suppress("unused", "unused_parameter")
abstract class ParsedHttpSource : HttpSource() {

    /**
     * Parses the response from the site and returns a [MangasPage] object.
     *
     * @param response the response from the site.
     */
    override fun popularMangaParse(response: Response): MangasPage {
        throw Exception("Stub!")
    }

    /**
     * Returns the Jsoup selector that returns a list of [Element] corresponding to each manga.
     */
    abstract protected fun popularMangaSelector(): String

    /**
     * Returns a manga from the given [element]. Most sites only show the title and the url, it's
     * totally fine to fill only those two values.
     *
     * @param element an element obtained from [popularMangaSelector].
     */
    abstract protected fun popularMangaFromElement(element: Element): SManga

    /**
     * Returns the Jsoup selector that returns the <a> tag linking to the next page, or null if
     * there's no next page.
     */
    abstract protected fun popularMangaNextPageSelector(): String?

    /**
     * Parses the response from the site and returns a [MangasPage] object.
     *
     * @param response the response from the site.
     */
    override fun searchMangaParse(response: Response): MangasPage {
        throw Exception("Stub!")
    }

    /**
     * Returns the Jsoup selector that returns a list of [Element] corresponding to each manga.
     */
    abstract protected fun searchMangaSelector(): String

    /**
     * Returns a manga from the given [element]. Most sites only show the title and the url, it's
     * totally fine to fill only those two values.
     *
     * @param element an element obtained from [searchMangaSelector].
     */
    abstract protected fun searchMangaFromElement(element: Element): SManga

    /**
     * Returns the Jsoup selector that returns the <a> tag linking to the next page, or null if
     * there's no next page.
     */
    abstract protected fun searchMangaNextPageSelector(): String?

    /**
     * Parses the response from the site and returns a [MangasPage] object.
     *
     * @param response the response from the site.
     */
    override fun latestUpdatesParse(response: Response): MangasPage {
        throw Exception("Stub!")
    }

    /**
     * Returns the Jsoup selector that returns a list of [Element] corresponding to each manga.
     */
    abstract protected fun latestUpdatesSelector(): String

    /**
     * Returns a manga from the given [element]. Most sites only show the title and the url, it's
     * totally fine to fill only those two values.
     *
     * @param element an element obtained from [latestUpdatesSelector].
     */
    abstract protected fun latestUpdatesFromElement(element: Element): SManga

    /**
     * Returns the Jsoup selector that returns the <a> tag linking to the next page, or null if
     * there's no next page.
     */
    abstract protected fun latestUpdatesNextPageSelector(): String?

    /**
     * Parses the response from the site and returns the details of a manga.
     *
     * @param response the response from the site.
     */
    override fun mangaDetailsParse(response: Response): SManga {
        throw Exception("Stub!")
    }

    /**
     * Returns the details of the manga from the given [document].
     *
     * @param document the parsed document.
     */
    abstract protected fun mangaDetailsParse(document: Document): SManga

    /**
     * Parses the response from the site and returns a list of chapters.
     *
     * @param response the response from the site.
     */
    override fun chapterListParse(response: Response): List<SChapter> {
        throw Exception("Stub!")
    }

    /**
     * Returns the Jsoup selector that returns a list of [Element] corresponding to each chapter.
     */
    abstract protected fun chapterListSelector(): String

    /**
     * Returns a chapter from the given element.
     *
     * @param element an element obtained from [chapterListSelector].
     */
    abstract protected fun chapterFromElement(element: Element): SChapter

    /**
     * Parses the response from the site and returns the page list.
     *
     * @param response the response from the site.
     */
    override fun pageListParse(response: Response): List<Page> {
        throw Exception("Stub!")
    }

    /**
     * Returns a page list from the given document.
     *
     * @param document the parsed document.
     */
    abstract protected fun pageListParse(document: Document): List<Page>

    /**
     * Parse the response from the site and returns the absolute url to the source image.
     *
     * @param response the response from the site.
     */
    override fun imageUrlParse(response: Response): String {
        throw Exception("Stub!")
    }

    /**
     * Returns the absolute url to the source image from the document.
     *
     * @param document the parsed document.
     */
    abstract protected fun imageUrlParse(document: Document): String
}

package com.namhyun.timesviewer;

import android.test.AndroidTestCase;
import android.util.Log;

import com.namhyun.timesviewer.api.NewsWire;
import com.namhyun.timesviewer.api.ResultContainer;

import java.util.List;

/**
 * Created by Namhyun, Gu on 2015-01-05.
 */
public class UnitTest extends AndroidTestCase {
    private final String testJsonStr = "{\n" +
            "    \"status\": \"OK\",\n" +
            "    \"copyright\": \"Copyright (c) 2015 The New York Times Company.  All Rights Reserved.\",\n" +
            "    \"num_results\": 46575,\n" +
            "    \"results\": [{\n" +
            "        \"section\": \"Business Day\",\n" +
            "        \"subsection\": \"Media\",\n" +
            "        \"title\": \"Popular Demand\",\n" +
            "        \"abstract\": \"The blogging websites on eBizMBA\\u2019s top 10 list ranked high when compared to their competitors.\",\n" +
            "        \"url\": \"http:\\/\\/www.nytimes.com\\/interactive\\/2015\\/01\\/05\\/business\\/media\\/05Most.html\",\n" +
            "        \"byline\": \"\",\n" +
            "        \"thumbnail_standard\": \"\",\n" +
            "        \"item_type\": \"Interactive\",\n" +
            "        \"source\": \"The New York Times\",\n" +
            "        \"updated_date\": \"2015-01-04T21:12:06-05:00\",\n" +
            "        \"created_date\": \"2015-01-04T21:03:33-05:00\",\n" +
            "        \"published_date\": \"2015-01-05T00:00:00-05:00\",\n" +
            "        \"material_type_facet\": \"\",\n" +
            "        \"kicker\": \"\",\n" +
            "        \"subheadline\": \"\",\n" +
            "        \"des_facet\": [\"Blogs and Blogging (Internet)\", \"News and News Media\"],\n" +
            "        \"org_facet\": [\"Yahoo! Inc\"],\n" +
            "        \"per_facet\": \"\",\n" +
            "        \"geo_facet\": \"\",\n" +
            "        \"related_urls\": [{\n" +
            "            \"suggested_link_text\": \"BROADCAST TELEVISION Dec. 22 through 28.*\",\n" +
            "            \"url\": \"http:\\/\\/www.nytimes.com\\/2015\\/01\\/05\\/business\\/broadcast-television-dec-22-through-28.html\"\n" +
            "        }],\n" +
            "        \"multimedia\": [{\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/05\\/business\\/05-submost\\/05-submost-thumbStandard.jpg\",\n" +
            "            \"format\": \"Standard Thumbnail\",\n" +
            "            \"height\": 75,\n" +
            "            \"width\": 75,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"\",\n" +
            "            \"caption\": \"\",\n" +
            "            \"copyright\": \"Michael Nelson\\/European Pressphoto Agency\"\n" +
            "        }, {\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/05\\/business\\/05-submost\\/05-submost-thumbLarge.jpg\",\n" +
            "            \"format\": \"thumbLarge\",\n" +
            "            \"height\": 150,\n" +
            "            \"width\": 150,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"\",\n" +
            "            \"caption\": \"\",\n" +
            "            \"copyright\": \"Michael Nelson\\/European Pressphoto Agency\"\n" +
            "        }, {\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/05\\/business\\/05-submost\\/05-submost-articleInline.jpg\",\n" +
            "            \"format\": \"Normal\",\n" +
            "            \"height\": 122,\n" +
            "            \"width\": 190,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"\",\n" +
            "            \"caption\": \"\",\n" +
            "            \"copyright\": \"Michael Nelson\\/European Pressphoto Agency\"\n" +
            "        }, {\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/05\\/business\\/05-submost\\/05-submost-mediumThreeByTwo210.jpg\",\n" +
            "            \"format\": \"mediumThreeByTwo210\",\n" +
            "            \"height\": 140,\n" +
            "            \"width\": 210,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"\",\n" +
            "            \"caption\": \"\",\n" +
            "            \"copyright\": \"Michael Nelson\\/European Pressphoto Agency\"\n" +
            "        }]\n" +
            "    }, {\n" +
            "        \"section\": \"Business Day\",\n" +
            "        \"subsection\": \"Media\",\n" +
            "        \"title\": \"Popular TV Series and Movies Maintain Relevance as Novels\",\n" +
            "        \"abstract\": \"As television experiences a new golden age, tie-in books, a long-maligned subgenre, have gained respectability.\",\n" +
            "        \"url\": \"http:\\/\\/www.nytimes.com\\/2015\\/01\\/05\\/business\\/media\\/popular-tv-series-and-movies-maintain-relevance-as-novels.html\",\n" +
            "        \"byline\": \"By ALEXANDRA ALTER\",\n" +
            "        \"thumbnail_standard\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/05\\/business\\/jp-NOVELIZATION-1\\/jp-NOVELIZATION-1-thumbStandard.jpg\",\n" +
            "        \"item_type\": \"Article\",\n" +
            "        \"source\": \"The New York Times\",\n" +
            "        \"updated_date\": \"2015-01-05T01:20:07-05:00\",\n" +
            "        \"created_date\": \"2015-01-04T20:38:28-05:00\",\n" +
            "        \"published_date\": \"2015-01-05T00:00:00-05:00\",\n" +
            "        \"material_type_facet\": \"News\",\n" +
            "        \"kicker\": \"\",\n" +
            "        \"subheadline\": \"\",\n" +
            "        \"des_facet\": [\"Writing and Writers\", \"Books and Literature\", \"Television\"],\n" +
            "        \"org_facet\": [\"Twitter|TWTR|NYSE\", \"Facebook Inc|FB|NASDAQ\"],\n" +
            "        \"per_facet\": \"\",\n" +
            "        \"geo_facet\": \"\",\n" +
            "        \"related_urls\": null,\n" +
            "        \"multimedia\": [{\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/05\\/business\\/jp-NOVELIZATION-1\\/jp-NOVELIZATION-1-thumbStandard.jpg\",\n" +
            "            \"format\": \"Standard Thumbnail\",\n" +
            "            \"height\": 75,\n" +
            "            \"width\": 75,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"photo\",\n" +
            "            \"caption\": \"The creator of &ldquo;Sons of Anarchy,&rdquo; which recently ended its seven-year run on FX, commissioned a novel to keep fans engaged with the show&rsquo;s characters.\",\n" +
            "            \"copyright\": \"Prashant Gupta\\/FX\"\n" +
            "        }, {\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/05\\/business\\/jp-NOVELIZATION-1\\/jp-NOVELIZATION-1-thumbLarge.jpg\",\n" +
            "            \"format\": \"thumbLarge\",\n" +
            "            \"height\": 150,\n" +
            "            \"width\": 150,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"photo\",\n" +
            "            \"caption\": \"The creator of &ldquo;Sons of Anarchy,&rdquo; which recently ended its seven-year run on FX, commissioned a novel to keep fans engaged with the show&rsquo;s characters.\",\n" +
            "            \"copyright\": \"Prashant Gupta\\/FX\"\n" +
            "        }, {\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/05\\/business\\/jp-NOVELIZATION-1\\/jp-NOVELIZATION-1-articleInline.jpg\",\n" +
            "            \"format\": \"Normal\",\n" +
            "            \"height\": 135,\n" +
            "            \"width\": 190,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"photo\",\n" +
            "            \"caption\": \"The creator of &ldquo;Sons of Anarchy,&rdquo; which recently ended its seven-year run on FX, commissioned a novel to keep fans engaged with the show&rsquo;s characters.\",\n" +
            "            \"copyright\": \"Prashant Gupta\\/FX\"\n" +
            "        }, {\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/05\\/business\\/jp-NOVELIZATION-1\\/jp-NOVELIZATION-1-mediumThreeByTwo210.jpg\",\n" +
            "            \"format\": \"mediumThreeByTwo210\",\n" +
            "            \"height\": 140,\n" +
            "            \"width\": 210,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"photo\",\n" +
            "            \"caption\": \"The creator of &ldquo;Sons of Anarchy,&rdquo; which recently ended its seven-year run on FX, commissioned a novel to keep fans engaged with the show&rsquo;s characters.\",\n" +
            "            \"copyright\": \"Prashant Gupta\\/FX\"\n" +
            "        }, {\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/05\\/business\\/jp-novelization-2\\/jp-novelization-2-thumbStandard.jpg\",\n" +
            "            \"format\": \"Standard Thumbnail\",\n" +
            "            \"height\": 75,\n" +
            "            \"width\": 75,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"photo\",\n" +
            "            \"caption\": \"\",\n" +
            "            \"copyright\": \"St Martins Press\"\n" +
            "        }, {\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/05\\/business\\/jp-novelization-2\\/jp-novelization-2-thumbLarge.jpg\",\n" +
            "            \"format\": \"thumbLarge\",\n" +
            "            \"height\": 150,\n" +
            "            \"width\": 150,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"photo\",\n" +
            "            \"caption\": \"\",\n" +
            "            \"copyright\": \"St Martins Press\"\n" +
            "        }, {\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/05\\/business\\/jp-novelization-2\\/jp-novelization-2-articleInline.jpg\",\n" +
            "            \"format\": \"Normal\",\n" +
            "            \"height\": 288,\n" +
            "            \"width\": 190,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"photo\",\n" +
            "            \"caption\": \"\",\n" +
            "            \"copyright\": \"St Martins Press\"\n" +
            "        }, {\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/05\\/business\\/jp-novelization-2\\/jp-novelization-2-mediumThreeByTwo210.jpg\",\n" +
            "            \"format\": \"mediumThreeByTwo210\",\n" +
            "            \"height\": 140,\n" +
            "            \"width\": 210,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"photo\",\n" +
            "            \"caption\": \"\",\n" +
            "            \"copyright\": \"St Martins Press\"\n" +
            "        }]\n" +
            "    }, {\n" +
            "        \"section\": \"Business Day\",\n" +
            "        \"subsection\": \"Media\",\n" +
            "        \"title\": \"Investigation Discovery Network Makes Crime Pay\",\n" +
            "        \"abstract\": \"Offering a sensational mix of romance-gone-wrong murder mysteries introduced by celebrity hosts, the network is welcomed into more than 100 million homes in 157 countries and territories.\",\n" +
            "        \"url\": \"http:\\/\\/www.nytimes.com\\/2015\\/01\\/05\\/business\\/media\\/investigation-discovery-network-makes-crime-pay.html\",\n" +
            "        \"byline\": \"By EMILY STEEL\",\n" +
            "        \"thumbnail_standard\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/05\\/business\\/05REALCRIME-1\\/05REALCRIME-1-thumbStandard.jpg\",\n" +
            "        \"item_type\": \"Article\",\n" +
            "        \"source\": \"The New York Times\",\n" +
            "        \"updated_date\": \"2015-01-05T00:08:20-05:00\",\n" +
            "        \"created_date\": \"2015-01-04T19:46:22-05:00\",\n" +
            "        \"published_date\": \"2015-01-05T00:00:00-05:00\",\n" +
            "        \"material_type_facet\": \"News\",\n" +
            "        \"kicker\": \"\",\n" +
            "        \"subheadline\": \"\",\n" +
            "        \"des_facet\": [\"Television\", \"Crime and Criminals\", \"Murders, Attempted Murders and Homicides\"],\n" +
            "        \"org_facet\": [\"Discovery Communications Inc\", \"Investigation Discovery\", \"Discovery Networks\"],\n" +
            "        \"per_facet\": \"\",\n" +
            "        \"geo_facet\": \"\",\n" +
            "        \"related_urls\": null,\n" +
            "        \"multimedia\": [{\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/05\\/business\\/05REALCRIME-1\\/05REALCRIME-1-thumbStandard.jpg\",\n" +
            "            \"format\": \"Standard Thumbnail\",\n" +
            "            \"height\": 75,\n" +
            "            \"width\": 75,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"photo\",\n" +
            "            \"caption\": \"Donna Cobb in &ldquo;Wives With Knives.&rdquo;\",\n" +
            "            \"copyright\": \"Investigation Discovery\"\n" +
            "        }, {\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/05\\/business\\/05REALCRIME-1\\/05REALCRIME-1-thumbLarge.jpg\",\n" +
            "            \"format\": \"thumbLarge\",\n" +
            "            \"height\": 150,\n" +
            "            \"width\": 150,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"photo\",\n" +
            "            \"caption\": \"Donna Cobb in &ldquo;Wives With Knives.&rdquo;\",\n" +
            "            \"copyright\": \"Investigation Discovery\"\n" +
            "        }, {\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/05\\/business\\/05REALCRIME-1\\/05REALCRIME-1-articleInline.jpg\",\n" +
            "            \"format\": \"Normal\",\n" +
            "            \"height\": 135,\n" +
            "            \"width\": 190,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"photo\",\n" +
            "            \"caption\": \"Donna Cobb in &ldquo;Wives With Knives.&rdquo;\",\n" +
            "            \"copyright\": \"Investigation Discovery\"\n" +
            "        }, {\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/05\\/business\\/05REALCRIME-1\\/05REALCRIME-1-mediumThreeByTwo210.jpg\",\n" +
            "            \"format\": \"mediumThreeByTwo210\",\n" +
            "            \"height\": 140,\n" +
            "            \"width\": 210,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"photo\",\n" +
            "            \"caption\": \"Donna Cobb in &ldquo;Wives With Knives.&rdquo;\",\n" +
            "            \"copyright\": \"Investigation Discovery\"\n" +
            "        }, {\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/05\\/business\\/05REALCRIME-3\\/05REALCRIME-3-thumbStandard.jpg\",\n" +
            "            \"format\": \"Standard Thumbnail\",\n" +
            "            \"height\": 75,\n" +
            "            \"width\": 75,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"photo\",\n" +
            "            \"caption\": \"Susan Lucci hosts &ldquo;Deadly Affairs.\\\"\",\n" +
            "            \"copyright\": \"Discovery Communications\"\n" +
            "        }, {\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/05\\/business\\/05REALCRIME-3\\/05REALCRIME-3-thumbLarge.jpg\",\n" +
            "            \"format\": \"thumbLarge\",\n" +
            "            \"height\": 150,\n" +
            "            \"width\": 150,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"photo\",\n" +
            "            \"caption\": \"Susan Lucci hosts &ldquo;Deadly Affairs.\\\"\",\n" +
            "            \"copyright\": \"Discovery Communications\"\n" +
            "        }, {\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/05\\/business\\/05REALCRIME-3\\/05REALCRIME-3-articleInline.jpg\",\n" +
            "            \"format\": \"Normal\",\n" +
            "            \"height\": 329,\n" +
            "            \"width\": 190,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"photo\",\n" +
            "            \"caption\": \"Susan Lucci hosts &ldquo;Deadly Affairs.\\\"\",\n" +
            "            \"copyright\": \"Discovery Communications\"\n" +
            "        }, {\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/05\\/business\\/05REALCRIME-3\\/05REALCRIME-3-mediumThreeByTwo210.jpg\",\n" +
            "            \"format\": \"mediumThreeByTwo210\",\n" +
            "            \"height\": 140,\n" +
            "            \"width\": 210,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"photo\",\n" +
            "            \"caption\": \"Susan Lucci hosts &ldquo;Deadly Affairs.\\\"\",\n" +
            "            \"copyright\": \"Discovery Communications\"\n" +
            "        }, {\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/05\\/business\\/05jpREALCRIME1\\/05jpREALCRIME1-thumbStandard.jpg\",\n" +
            "            \"format\": \"Standard Thumbnail\",\n" +
            "            \"height\": 75,\n" +
            "            \"width\": 75,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"photo\",\n" +
            "            \"caption\": \"Actors as Mark Mangelsdorf and Melinda Harmon in &ldquo;Deadly Affairs.&rdquo; He pleaded guilty 24 years later to killing her husband.\",\n" +
            "            \"copyright\": \"Investigation Discovery\"\n" +
            "        }, {\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/05\\/business\\/05jpREALCRIME1\\/05jpREALCRIME1-thumbLarge.jpg\",\n" +
            "            \"format\": \"thumbLarge\",\n" +
            "            \"height\": 150,\n" +
            "            \"width\": 150,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"photo\",\n" +
            "            \"caption\": \"Actors as Mark Mangelsdorf and Melinda Harmon in &ldquo;Deadly Affairs.&rdquo; He pleaded guilty 24 years later to killing her husband.\",\n" +
            "            \"copyright\": \"Investigation Discovery\"\n" +
            "        }, {\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/05\\/business\\/05jpREALCRIME1\\/05jpREALCRIME1-articleInline.jpg\",\n" +
            "            \"format\": \"Normal\",\n" +
            "            \"height\": 268,\n" +
            "            \"width\": 190,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"photo\",\n" +
            "            \"caption\": \"Actors as Mark Mangelsdorf and Melinda Harmon in &ldquo;Deadly Affairs.&rdquo; He pleaded guilty 24 years later to killing her husband.\",\n" +
            "            \"copyright\": \"Investigation Discovery\"\n" +
            "        }, {\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/05\\/business\\/05jpREALCRIME1\\/05jpREALCRIME1-mediumThreeByTwo210.jpg\",\n" +
            "            \"format\": \"mediumThreeByTwo210\",\n" +
            "            \"height\": 140,\n" +
            "            \"width\": 210,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"photo\",\n" +
            "            \"caption\": \"Actors as Mark Mangelsdorf and Melinda Harmon in &ldquo;Deadly Affairs.&rdquo; He pleaded guilty 24 years later to killing her husband.\",\n" +
            "            \"copyright\": \"Investigation Discovery\"\n" +
            "        }, {\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/05\\/business\\/05jpREALCRIME2\\/05jpREALCRIME2-thumbStandard.jpg\",\n" +
            "            \"format\": \"Standard Thumbnail\",\n" +
            "            \"height\": 75,\n" +
            "            \"width\": 75,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"photo\",\n" +
            "            \"caption\": \"Henry Schleiff, group president, Investigation Discovery.\",\n" +
            "            \"copyright\": \"Amanda Edwards\\/Getty Images\"\n" +
            "        }, {\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/05\\/business\\/05jpREALCRIME2\\/05jpREALCRIME2-thumbLarge.jpg\",\n" +
            "            \"format\": \"thumbLarge\",\n" +
            "            \"height\": 150,\n" +
            "            \"width\": 150,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"photo\",\n" +
            "            \"caption\": \"Henry Schleiff, group president, Investigation Discovery.\",\n" +
            "            \"copyright\": \"Amanda Edwards\\/Getty Images\"\n" +
            "        }, {\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/05\\/business\\/05jpREALCRIME2\\/05jpREALCRIME2-articleInline.jpg\",\n" +
            "            \"format\": \"Normal\",\n" +
            "            \"height\": 211,\n" +
            "            \"width\": 190,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"photo\",\n" +
            "            \"caption\": \"Henry Schleiff, group president, Investigation Discovery.\",\n" +
            "            \"copyright\": \"Amanda Edwards\\/Getty Images\"\n" +
            "        }, {\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/05\\/business\\/05jpREALCRIME2\\/05jpREALCRIME2-mediumThreeByTwo210.jpg\",\n" +
            "            \"format\": \"mediumThreeByTwo210\",\n" +
            "            \"height\": 140,\n" +
            "            \"width\": 210,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"photo\",\n" +
            "            \"caption\": \"Henry Schleiff, group president, Investigation Discovery.\",\n" +
            "            \"copyright\": \"Amanda Edwards\\/Getty Images\"\n" +
            "        }]\n" +
            "    }, {\n" +
            "        \"section\": \"Business Day\",\n" +
            "        \"subsection\": \"Dealbook\",\n" +
            "        \"title\": \"Investors Bought Into Nearly $250 Billion in Global I.P.O.s in 2014 \",\n" +
            "        \"abstract\": \"Even excluding the $25 billion Alibaba offering, a phenomenon in its own right, the value of worldwide initial public offerings was up nearly 36 percent over 2013.\",\n" +
            "        \"url\": \"http:\\/\\/dealbook.nytimes.com\\/2015\\/01\\/04\\/investors-bought-into-nearly-250-billion-in-global-i-p-o-s-in-2014\\/\",\n" +
            "        \"byline\": \"By MICHAEL J. DE LA MERCED\",\n" +
            "        \"thumbnail_standard\": \"\",\n" +
            "        \"item_type\": \"Blog\",\n" +
            "        \"source\": \"The New York Times\",\n" +
            "        \"updated_date\": \"2015-01-04T20:00:15-05:00\",\n" +
            "        \"created_date\": \"2015-01-04T19:26:16-05:00\",\n" +
            "        \"published_date\": \"2015-01-04T00:00:00-05:00\",\n" +
            "        \"material_type_facet\": \"News\",\n" +
            "        \"kicker\": \"DealBook\",\n" +
            "        \"subheadline\": \"\",\n" +
            "        \"des_facet\": [\"Initial Public Offerings\", \"Private Equity\", \"Stocks and Bonds\", \"Venture Capital\"],\n" +
            "        \"org_facet\": \"\",\n" +
            "        \"per_facet\": \"\",\n" +
            "        \"geo_facet\": \"\",\n" +
            "        \"related_urls\": null,\n" +
            "        \"blog_name\": \"DealBook\",\n" +
            "        \"multimedia\": [{\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/05\\/business\\/dbpix-go-pro\\/dbpix-go-pro-thumbStandard.jpg\",\n" +
            "            \"format\": \"Standard Thumbnail\",\n" +
            "            \"height\": 75,\n" +
            "            \"width\": 75,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"photo\",\n" +
            "            \"caption\": \"\",\n" +
            "            \"copyright\": \"\"\n" +
            "        }]\n" +
            "    }, {\n" +
            "        \"section\": \"Business Day\",\n" +
            "        \"subsection\": \"\",\n" +
            "        \"title\": \"Treasury Auctions for the Week of Jan. 5\",\n" +
            "        \"abstract\": \"The following tax-exempt fixed-income issues are scheduled for pricing this week.\",\n" +
            "        \"url\": \"http:\\/\\/www.nytimes.com\\/2015\\/01\\/05\\/business\\/treasury-auctions-for-the-week-of-jan-5.html\",\n" +
            "        \"byline\": \"\",\n" +
            "        \"thumbnail_standard\": \"\",\n" +
            "        \"item_type\": \"Article\",\n" +
            "        \"source\": \"The New York Times\",\n" +
            "        \"updated_date\": \"2015-01-05T00:13:07-05:00\",\n" +
            "        \"created_date\": \"2015-01-04T18:57:16-05:00\",\n" +
            "        \"published_date\": \"2015-01-05T00:00:00-05:00\",\n" +
            "        \"material_type_facet\": \"Schedule\",\n" +
            "        \"kicker\": \"\",\n" +
            "        \"subheadline\": \"\",\n" +
            "        \"des_facet\": [\"Stocks and Bonds\"],\n" +
            "        \"org_facet\": [\"Treasury Department\"],\n" +
            "        \"per_facet\": \"\",\n" +
            "        \"geo_facet\": \"\",\n" +
            "        \"related_urls\": null,\n" +
            "        \"multimedia\": \"\"\n" +
            "    }, {\n" +
            "        \"section\": \"Business Day\",\n" +
            "        \"subsection\": \"Media\",\n" +
            "        \"title\": \"How \\u20181989\\u2019 Edged Out \\u2018Frozen\\u2019 as the No. 1 Album of 2014, and Vice Versa\",\n" +
            "        \"abstract\": \"As streaming grows in popularity, competing album sales metrics that yielded two different No. 1 albums illustrate the music industry at a crossroads.\",\n" +
            "        \"url\": \"http:\\/\\/www.nytimes.com\\/2015\\/01\\/05\\/business\\/media\\/how-1989-edged-out-frozen-as-the-no-1-album-of-2014-and-vice-versa.html\",\n" +
            "        \"byline\": \"By BEN SISARIO\",\n" +
            "        \"thumbnail_standard\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/05\\/business\\/05music\\/05music-thumbStandard.jpg\",\n" +
            "        \"item_type\": \"Article\",\n" +
            "        \"source\": \"The New York Times\",\n" +
            "        \"updated_date\": \"2015-01-05T00:07:46-05:00\",\n" +
            "        \"created_date\": \"2015-01-04T18:46:00-05:00\",\n" +
            "        \"published_date\": \"2015-01-05T00:00:00-05:00\",\n" +
            "        \"material_type_facet\": \"News\",\n" +
            "        \"kicker\": \"\",\n" +
            "        \"subheadline\": \"\",\n" +
            "        \"des_facet\": [\"Audio Recordings, Downloads and Streaming\", \"Music\"],\n" +
            "        \"org_facet\": [\"Spotify\", \"YouTube.com\"],\n" +
            "        \"per_facet\": [\"Swift, Taylor\"],\n" +
            "        \"geo_facet\": \"\",\n" +
            "        \"related_urls\": null,\n" +
            "        \"multimedia\": [{\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/05\\/business\\/05music\\/05music-thumbStandard.jpg\",\n" +
            "            \"format\": \"Standard Thumbnail\",\n" +
            "            \"height\": 75,\n" +
            "            \"width\": 75,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"photo\",\n" +
            "            \"caption\": \"Taylor Swift&rsquo;s &ldquo;1989,&rdquo; which was released in October, posted sales of nearly 1.3 million albums in its first week, the fastest a record has sold since 2002.\",\n" +
            "            \"copyright\": \"Chad Batka for The New York Times\"\n" +
            "        }, {\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/05\\/business\\/05music\\/05music-thumbLarge.jpg\",\n" +
            "            \"format\": \"thumbLarge\",\n" +
            "            \"height\": 150,\n" +
            "            \"width\": 150,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"photo\",\n" +
            "            \"caption\": \"Taylor Swift&rsquo;s &ldquo;1989,&rdquo; which was released in October, posted sales of nearly 1.3 million albums in its first week, the fastest a record has sold since 2002.\",\n" +
            "            \"copyright\": \"Chad Batka for The New York Times\"\n" +
            "        }, {\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/05\\/business\\/05music\\/05music-articleInline.jpg\",\n" +
            "            \"format\": \"Normal\",\n" +
            "            \"height\": 141,\n" +
            "            \"width\": 190,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"photo\",\n" +
            "            \"caption\": \"Taylor Swift&rsquo;s &ldquo;1989,&rdquo; which was released in October, posted sales of nearly 1.3 million albums in its first week, the fastest a record has sold since 2002.\",\n" +
            "            \"copyright\": \"Chad Batka for The New York Times\"\n" +
            "        }, {\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/05\\/business\\/05music\\/05music-mediumThreeByTwo210.jpg\",\n" +
            "            \"format\": \"mediumThreeByTwo210\",\n" +
            "            \"height\": 140,\n" +
            "            \"width\": 210,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"photo\",\n" +
            "            \"caption\": \"Taylor Swift&rsquo;s &ldquo;1989,&rdquo; which was released in October, posted sales of nearly 1.3 million albums in its first week, the fastest a record has sold since 2002.\",\n" +
            "            \"copyright\": \"Chad Batka for The New York Times\"\n" +
            "        }, {\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/05\\/business\\/05jpMUSIC\\/05jpMUSIC-thumbStandard.jpg\",\n" +
            "            \"format\": \"Standard Thumbnail\",\n" +
            "            \"height\": 75,\n" +
            "            \"width\": 75,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"photo\",\n" +
            "            \"caption\": \"Bono, right, and The Edge of U2. The band was criticized by some after it gave away its latest album through Apple&rsquo;s iTunes.\",\n" +
            "            \"copyright\": \"Samir Hussein\\/Getty Images for MTV\"\n" +
            "        }, {\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/05\\/business\\/05jpMUSIC\\/05jpMUSIC-thumbLarge.jpg\",\n" +
            "            \"format\": \"thumbLarge\",\n" +
            "            \"height\": 150,\n" +
            "            \"width\": 150,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"photo\",\n" +
            "            \"caption\": \"Bono, right, and The Edge of U2. The band was criticized by some after it gave away its latest album through Apple&rsquo;s iTunes.\",\n" +
            "            \"copyright\": \"Samir Hussein\\/Getty Images for MTV\"\n" +
            "        }, {\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/05\\/business\\/05jpMUSIC\\/05jpMUSIC-articleInline.jpg\",\n" +
            "            \"format\": \"Normal\",\n" +
            "            \"height\": 127,\n" +
            "            \"width\": 190,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"photo\",\n" +
            "            \"caption\": \"Bono, right, and The Edge of U2. The band was criticized by some after it gave away its latest album through Apple&rsquo;s iTunes.\",\n" +
            "            \"copyright\": \"Samir Hussein\\/Getty Images for MTV\"\n" +
            "        }, {\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/05\\/business\\/05jpMUSIC\\/05jpMUSIC-mediumThreeByTwo210.jpg\",\n" +
            "            \"format\": \"mediumThreeByTwo210\",\n" +
            "            \"height\": 140,\n" +
            "            \"width\": 210,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"photo\",\n" +
            "            \"caption\": \"Bono, right, and The Edge of U2. The band was criticized by some after it gave away its latest album through Apple&rsquo;s iTunes.\",\n" +
            "            \"copyright\": \"Samir Hussein\\/Getty Images for MTV\"\n" +
            "        }]\n" +
            "    }, {\n" +
            "        \"section\": \"Business Day\",\n" +
            "        \"subsection\": \"Media\",\n" +
            "        \"title\": \"Selfies on a Stick, and the Social-Content Challenge for the Media\",\n" +
            "        \"abstract\": \"The tendency to listen to the holy music of the self is reflected in the abundance of messaging and self-publishing services, all of which pose a profound challenge for media companies.\",\n" +
            "        \"url\": \"http:\\/\\/www.nytimes.com\\/2015\\/01\\/05\\/business\\/media\\/selfies-on-a-stick-and-the-social-content-challenge-for-the-media.html\",\n" +
            "        \"byline\": \"By DAVID CARR\",\n" +
            "        \"thumbnail_standard\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/05\\/business\\/05jpcarr\\/05jpcarr-thumbStandard.jpg\",\n" +
            "        \"item_type\": \"Article\",\n" +
            "        \"source\": \"The New York Times\",\n" +
            "        \"updated_date\": \"2015-01-05T00:01:06-05:00\",\n" +
            "        \"created_date\": \"2015-01-04T18:26:10-05:00\",\n" +
            "        \"published_date\": \"2015-01-05T00:00:00-05:00\",\n" +
            "        \"material_type_facet\": \"News\",\n" +
            "        \"kicker\": \"The Media Equation\",\n" +
            "        \"subheadline\": \"\",\n" +
            "        \"des_facet\": [\"Social Media\", \"Photography\", \"Computers and the Internet\"],\n" +
            "        \"org_facet\": [\"WhatsApp Inc\", \"Instagram Inc\", \"Twitter\", \"Facebook Inc\", \"YouTube.com\", \"Snapchat Inc\"],\n" +
            "        \"per_facet\": \"\",\n" +
            "        \"geo_facet\": \"\",\n" +
            "        \"related_urls\": null,\n" +
            "        \"multimedia\": [{\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/05\\/business\\/05jpcarr\\/05jpcarr-thumbStandard.jpg\",\n" +
            "            \"format\": \"Standard Thumbnail\",\n" +
            "            \"height\": 75,\n" +
            "            \"width\": 75,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"photo\",\n" +
            "            \"caption\": \"A family commemorates New Year&rsquo;s Eve in Times Square using a collapsible pole that improves camera angles for self-portraits.\",\n" +
            "            \"copyright\": \"Zoran Milich\\/Reuters\"\n" +
            "        }, {\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/05\\/business\\/05jpcarr\\/05jpcarr-thumbLarge.jpg\",\n" +
            "            \"format\": \"thumbLarge\",\n" +
            "            \"height\": 150,\n" +
            "            \"width\": 150,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"photo\",\n" +
            "            \"caption\": \"A family commemorates New Year&rsquo;s Eve in Times Square using a collapsible pole that improves camera angles for self-portraits.\",\n" +
            "            \"copyright\": \"Zoran Milich\\/Reuters\"\n" +
            "        }, {\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/05\\/business\\/05jpcarr\\/05jpcarr-articleInline.jpg\",\n" +
            "            \"format\": \"Normal\",\n" +
            "            \"height\": 127,\n" +
            "            \"width\": 190,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"photo\",\n" +
            "            \"caption\": \"A family commemorates New Year&rsquo;s Eve in Times Square using a collapsible pole that improves camera angles for self-portraits.\",\n" +
            "            \"copyright\": \"Zoran Milich\\/Reuters\"\n" +
            "        }, {\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/05\\/business\\/05jpcarr\\/05jpcarr-mediumThreeByTwo210.jpg\",\n" +
            "            \"format\": \"mediumThreeByTwo210\",\n" +
            "            \"height\": 140,\n" +
            "            \"width\": 210,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"photo\",\n" +
            "            \"caption\": \"A family commemorates New Year&rsquo;s Eve in Times Square using a collapsible pole that improves camera angles for self-portraits.\",\n" +
            "            \"copyright\": \"Zoran Milich\\/Reuters\"\n" +
            "        }]\n" +
            "    }, {\n" +
            "        \"section\": \"Business Day\",\n" +
            "        \"subsection\": \"Economy\",\n" +
            "        \"title\": \"December Auto Sales, and Job Data for U.S. and Europe\",\n" +
            "        \"abstract\": \"On Monday, automakers will release December sales figures, in what analysts expect will cap a strong year; employment data will come from Europe and then the United States.\",\n" +
            "        \"url\": \"http:\\/\\/www.nytimes.com\\/2015\\/01\\/05\\/business\\/economy\\/december-auto-sales-and-job-data-for-us-and-europe.html\",\n" +
            "        \"byline\": \"By AARON M. KESSLER\",\n" +
            "        \"thumbnail_standard\": \"\",\n" +
            "        \"item_type\": \"Article\",\n" +
            "        \"source\": \"The New York Times\",\n" +
            "        \"updated_date\": \"2015-01-05T00:11:08-05:00\",\n" +
            "        \"created_date\": \"2015-01-04T17:23:01-05:00\",\n" +
            "        \"published_date\": \"2015-01-05T00:00:00-05:00\",\n" +
            "        \"material_type_facet\": \"News\",\n" +
            "        \"kicker\": \"The Week Ahead\",\n" +
            "        \"subheadline\": \"\",\n" +
            "        \"des_facet\": [\"United States Economy\", \"Labor and Jobs\", \"Automobiles\"],\n" +
            "        \"org_facet\": [\"Eurostat\", \"Eurozone\", \"Federal Reserve System\"],\n" +
            "        \"per_facet\": [\"Appelbaum, Binyamin\"],\n" +
            "        \"geo_facet\": [\"Europe\", \"United States\"],\n" +
            "        \"related_urls\": null,\n" +
            "        \"multimedia\": \"\"\n" +
            "    }, {\n" +
            "        \"section\": \"Business Day\",\n" +
            "        \"subsection\": \"International Business\",\n" +
            "        \"title\": \"Secrets to Success: Passion and Some Luck\",\n" +
            "        \"abstract\": \"James Zhonglei Wang is president of the Huayi Brothers Media Corporation, a Chinese entertainment and film production company that he co-founded in 1994.\",\n" +
            "        \"url\": \"http:\\/\\/www.nytimes.com\\/2015\\/01\\/05\\/business\\/international\\/secrets-to-success-passion-and-some-luck.html\",\n" +
            "        \"byline\": \"By SONIA KOLESNIKOV-JESSOP\",\n" +
            "        \"thumbnail_standard\": \"\",\n" +
            "        \"item_type\": \"Article\",\n" +
            "        \"source\": \"International New York Times\",\n" +
            "        \"updated_date\": \"2015-01-05T00:41:07-05:00\",\n" +
            "        \"created_date\": \"2015-01-04T04:27:27-05:00\",\n" +
            "        \"published_date\": \"2015-01-05T00:00:00-05:00\",\n" +
            "        \"material_type_facet\": \"Question\",\n" +
            "        \"kicker\": \"\",\n" +
            "        \"subheadline\": \"\",\n" +
            "        \"des_facet\": [\"Executives and Management (Theory)\"],\n" +
            "        \"org_facet\": [\"Huayi Brothers Media Corp\"],\n" +
            "        \"per_facet\": [\"James Zhonglei Wang\"],\n" +
            "        \"geo_facet\": \"\",\n" +
            "        \"related_urls\": null,\n" +
            "        \"multimedia\": \"\"\n" +
            "    }, {\n" +
            "        \"section\": \"Business Day\",\n" +
            "        \"subsection\": \"\",\n" +
            "        \"title\": \"The Economics (and Nostalgia) of Dead Malls\",\n" +
            "        \"abstract\": \"High-end shopping malls are thriving across the country, but as midtier retailers like Sears and J. C. Penney flounder, they are also dragging down their malls.\",\n" +
            "        \"url\": \"http:\\/\\/www.nytimes.com\\/2015\\/01\\/04\\/business\\/the-economics-and-nostalgia-of-dead-malls.html\",\n" +
            "        \"byline\": \"By NELSON D. SCHWARTZ\",\n" +
            "        \"thumbnail_standard\": \"\",\n" +
            "        \"item_type\": \"Article\",\n" +
            "        \"source\": \"The New York Times\",\n" +
            "        \"updated_date\": \"2015-01-04T03:03:07-05:00\",\n" +
            "        \"created_date\": \"2015-01-03T17:00:16-05:00\",\n" +
            "        \"published_date\": \"2015-01-04T00:00:00-05:00\",\n" +
            "        \"material_type_facet\": \"News\",\n" +
            "        \"kicker\": \"\",\n" +
            "        \"subheadline\": \"\",\n" +
            "        \"des_facet\": [\"Shopping Centers and Malls\", \"Real Estate (Commercial)\", \"Shopping and Retail\"],\n" +
            "        \"org_facet\": [\"Wet Seal Inc.|WTSL|NASDAQ\", \"Costco Wholesale Corporation|COST|NASDAQ\", \"JC Penney Company Inc|JCP|NYSE\", \"CoStar Group Inc|CSGP|NASDAQ\", \"Best BUY Company Inc|BBY|NYSE\", \"Target Corporation|TGT|NYSE\", \"Sears Holdings Corporation|SHLD|NASDAQ\"],\n" +
            "        \"per_facet\": \"\",\n" +
            "        \"geo_facet\": [\"Ohio\", \"Akron (Ohio)\", \"Baltimore (Md)\"],\n" +
            "        \"related_urls\": null,\n" +
            "        \"multimedia\": \"\"\n" +
            "    }, {\n" +
            "        \"section\": \"Business Day\",\n" +
            "        \"subsection\": \"\",\n" +
            "        \"title\": \"Whole Foods\\u2019 High Hurdle for Investors\",\n" +
            "        \"abstract\": \"Whole Foods Market got the S.E.C.&#8217;s permission to exclude from its proxy a shareholder proposal on director nominations, and 10 other companies now want to do the same.\",\n" +
            "        \"url\": \"http:\\/\\/www.nytimes.com\\/2015\\/01\\/04\\/business\\/whole-foods-high-hurdle-for-investors-.html\",\n" +
            "        \"byline\": \"By GRETCHEN MORGENSON\",\n" +
            "        \"thumbnail_standard\": \"\",\n" +
            "        \"item_type\": \"Article\",\n" +
            "        \"source\": \"The New York Times\",\n" +
            "        \"updated_date\": \"2015-01-03T13:02:15-05:00\",\n" +
            "        \"created_date\": \"2015-01-03T10:05:17-05:00\",\n" +
            "        \"published_date\": \"2015-01-04T00:00:00-05:00\",\n" +
            "        \"material_type_facet\": \"News\",\n" +
            "        \"kicker\": \"Fair Game\",\n" +
            "        \"subheadline\": \"\",\n" +
            "        \"des_facet\": [\"Boards of Directors\", \"Shareholder Rights and Activism\"],\n" +
            "        \"org_facet\": [\"Whole Foods Market Inc\", \"Securities and Exchange Commission\"],\n" +
            "        \"per_facet\": [\"McRitchie, James (1948- )\", \"Stringer, Scott M\"],\n" +
            "        \"geo_facet\": \"\",\n" +
            "        \"related_urls\": null,\n" +
            "        \"multimedia\": \"\"\n" +
            "    }, {\n" +
            "        \"section\": \"Business Day\",\n" +
            "        \"subsection\": \"\",\n" +
            "        \"title\": \"Maynard Webb, Yahoo&#8217;s Chairman: Even the Best Teams Can Be Better\",\n" +
            "        \"abstract\": \"A veteran tech executive says that in general, companies spend too much time on poor performers and not enough on making \\u201cA-plus\\u201d employees better.\",\n" +
            "        \"url\": \"http:\\/\\/www.nytimes.com\\/2015\\/01\\/04\\/business\\/corner-office-maynard-webb-yahoos-chairman-even-the-best-teams-can-be-better.html\",\n" +
            "        \"byline\": \"By ADAM BRYANT\",\n" +
            "        \"thumbnail_standard\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/04\\/business\\/04-CORNER\\/04-CORNER-thumbStandard.jpg\",\n" +
            "        \"item_type\": \"Article\",\n" +
            "        \"source\": \"The New York Times\",\n" +
            "        \"updated_date\": \"2015-01-04T19:53:09-05:00\",\n" +
            "        \"created_date\": \"2015-01-03T10:00:16-05:00\",\n" +
            "        \"published_date\": \"2015-01-04T00:00:00-05:00\",\n" +
            "        \"material_type_facet\": \"Question\",\n" +
            "        \"kicker\": \"Corner Office\",\n" +
            "        \"subheadline\": \"\",\n" +
            "        \"des_facet\": [\"Hiring and Promotion\"],\n" +
            "        \"org_facet\": [\"Yahoo! Inc\"],\n" +
            "        \"per_facet\": [\"Webb, Maynard\"],\n" +
            "        \"geo_facet\": \"\",\n" +
            "        \"related_urls\": [{\n" +
            "            \"suggested_link_text\": \"Even the Best Team Can Be Better \",\n" +
            "            \"url\": \"http:\\/\\/www.nytimes.com\\/2015\\/01\\/04\\/business\\/even-the-best-team-can-be-better.html\"\n" +
            "        }],\n" +
            "        \"multimedia\": [{\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/04\\/business\\/04-CORNER\\/04-CORNER-thumbStandard.jpg\",\n" +
            "            \"format\": \"Standard Thumbnail\",\n" +
            "            \"height\": 75,\n" +
            "            \"width\": 75,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"photo\",\n" +
            "            \"caption\": \"&ldquo;You have to get voted onto the team every day as an employee, and you have to be the employer of choice every day. I would often ask team leaders: &lsquo;You have seven people working for you. How many of those would you rehire if all the positions were open again?&rsquo;&rdquo;\",\n" +
            "            \"copyright\": \"Earl Wilson\\/The New York Times\"\n" +
            "        }, {\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/04\\/business\\/04-CORNER\\/04-CORNER-thumbLarge.jpg\",\n" +
            "            \"format\": \"thumbLarge\",\n" +
            "            \"height\": 150,\n" +
            "            \"width\": 150,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"photo\",\n" +
            "            \"caption\": \"&ldquo;You have to get voted onto the team every day as an employee, and you have to be the employer of choice every day. I would often ask team leaders: &lsquo;You have seven people working for you. How many of those would you rehire if all the positions were open again?&rsquo;&rdquo;\",\n" +
            "            \"copyright\": \"Earl Wilson\\/The New York Times\"\n" +
            "        }, {\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/04\\/business\\/04-CORNER\\/04-CORNER-articleInline.jpg\",\n" +
            "            \"format\": \"Normal\",\n" +
            "            \"height\": 290,\n" +
            "            \"width\": 190,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"photo\",\n" +
            "            \"caption\": \"&ldquo;You have to get voted onto the team every day as an employee, and you have to be the employer of choice every day. I would often ask team leaders: &lsquo;You have seven people working for you. How many of those would you rehire if all the positions were open again?&rsquo;&rdquo;\",\n" +
            "            \"copyright\": \"Earl Wilson\\/The New York Times\"\n" +
            "        }, {\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/04\\/business\\/04-CORNER\\/04-CORNER-mediumThreeByTwo210.jpg\",\n" +
            "            \"format\": \"mediumThreeByTwo210\",\n" +
            "            \"height\": 140,\n" +
            "            \"width\": 210,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"photo\",\n" +
            "            \"caption\": \"&ldquo;You have to get voted onto the team every day as an employee, and you have to be the employer of choice every day. I would often ask team leaders: &lsquo;You have seven people working for you. How many of those would you rehire if all the positions were open again?&rsquo;&rdquo;\",\n" +
            "            \"copyright\": \"Earl Wilson\\/The New York Times\"\n" +
            "        }]\n" +
            "    }, {\n" +
            "        \"section\": \"Business Day\",\n" +
            "        \"subsection\": \"\",\n" +
            "        \"title\": \"Learning a Foreign Language Called Public Relations \",\n" +
            "        \"abstract\": \"Despite being utterly clueless about the business world, a hired writer soon won over a start-up company&#8217;s team.\",\n" +
            "        \"url\": \"http:\\/\\/www.nytimes.com\\/2015\\/01\\/04\\/business\\/learning-a-foreign-language-called-public-relations.html\",\n" +
            "        \"byline\": \"By JOHN D. WAGNER\",\n" +
            "        \"thumbnail_standard\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/04\\/business\\/4-ONWORK\\/4-ONWORK-thumbStandard.jpg\",\n" +
            "        \"item_type\": \"Article\",\n" +
            "        \"source\": \"The New York Times\",\n" +
            "        \"updated_date\": \"2015-01-03T23:29:14-05:00\",\n" +
            "        \"created_date\": \"2015-01-03T09:50:08-05:00\",\n" +
            "        \"published_date\": \"2015-01-04T00:00:00-05:00\",\n" +
            "        \"material_type_facet\": \"News\",\n" +
            "        \"kicker\": \"On Work\",\n" +
            "        \"subheadline\": \"\",\n" +
            "        \"des_facet\": [\"Labor and Jobs\", \"Public Relations and Publicity\", \"Venture Capital\"],\n" +
            "        \"org_facet\": \"\",\n" +
            "        \"per_facet\": \"\",\n" +
            "        \"geo_facet\": \"\",\n" +
            "        \"related_urls\": null,\n" +
            "        \"multimedia\": [{\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/04\\/business\\/4-ONWORK\\/4-ONWORK-thumbStandard.jpg\",\n" +
            "            \"format\": \"Standard Thumbnail\",\n" +
            "            \"height\": 75,\n" +
            "            \"width\": 75,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"photo\",\n" +
            "            \"caption\": \"\",\n" +
            "            \"copyright\": \"Koren Shadmi\"\n" +
            "        }, {\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/04\\/business\\/4-ONWORK\\/4-ONWORK-thumbLarge.jpg\",\n" +
            "            \"format\": \"thumbLarge\",\n" +
            "            \"height\": 150,\n" +
            "            \"width\": 150,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"photo\",\n" +
            "            \"caption\": \"\",\n" +
            "            \"copyright\": \"Koren Shadmi\"\n" +
            "        }, {\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/04\\/business\\/4-ONWORK\\/4-ONWORK-articleInline.jpg\",\n" +
            "            \"format\": \"Normal\",\n" +
            "            \"height\": 131,\n" +
            "            \"width\": 190,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"photo\",\n" +
            "            \"caption\": \"\",\n" +
            "            \"copyright\": \"Koren Shadmi\"\n" +
            "        }, {\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/04\\/business\\/4-ONWORK\\/4-ONWORK-mediumThreeByTwo210.jpg\",\n" +
            "            \"format\": \"mediumThreeByTwo210\",\n" +
            "            \"height\": 140,\n" +
            "            \"width\": 210,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"photo\",\n" +
            "            \"caption\": \"\",\n" +
            "            \"copyright\": \"Koren Shadmi\"\n" +
            "        }]\n" +
            "    }, {\n" +
            "        \"section\": \"Business Day\",\n" +
            "        \"subsection\": \"\",\n" +
            "        \"title\": \"If You Want to Meet That Deadline, Play a Trick on Your Mind\",\n" +
            "        \"abstract\": \"By tweaking our perception of time, research shows, we can more easily attain a goal &#8212; or meet a New Year&#8217;s resolution.\",\n" +
            "        \"url\": \"http:\\/\\/www.nytimes.com\\/2015\\/01\\/04\\/business\\/if-you-want-to-meet-that-deadline-play-a-trick-on-your-mind.html\",\n" +
            "        \"byline\": \"By PHYLLIS KORKKI\",\n" +
            "        \"thumbnail_standard\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/04\\/business\\/4-APPLIED\\/4-APPLIED-thumbStandard.jpg\",\n" +
            "        \"item_type\": \"Article\",\n" +
            "        \"source\": \"The New York Times\",\n" +
            "        \"updated_date\": \"2015-01-03T19:15:16-05:00\",\n" +
            "        \"created_date\": \"2015-01-03T09:45:20-05:00\",\n" +
            "        \"published_date\": \"2015-01-04T00:00:00-05:00\",\n" +
            "        \"material_type_facet\": \"News\",\n" +
            "        \"kicker\": \"Applied Science\",\n" +
            "        \"subheadline\": \"\",\n" +
            "        \"des_facet\": [\"Research\", \"New Year\"],\n" +
            "        \"org_facet\": [\"Journal of Consumer Research\"],\n" +
            "        \"per_facet\": \"\",\n" +
            "        \"geo_facet\": \"\",\n" +
            "        \"related_urls\": null,\n" +
            "        \"multimedia\": [{\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/04\\/business\\/4-APPLIED\\/4-APPLIED-thumbStandard.jpg\",\n" +
            "            \"format\": \"Standard Thumbnail\",\n" +
            "            \"height\": 75,\n" +
            "            \"width\": 75,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"photo\",\n" +
            "            \"caption\": \"\",\n" +
            "            \"copyright\": \"Michael Waraksa\"\n" +
            "        }, {\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/04\\/business\\/4-APPLIED\\/4-APPLIED-thumbLarge.jpg\",\n" +
            "            \"format\": \"thumbLarge\",\n" +
            "            \"height\": 150,\n" +
            "            \"width\": 150,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"photo\",\n" +
            "            \"caption\": \"\",\n" +
            "            \"copyright\": \"Michael Waraksa\"\n" +
            "        }, {\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/04\\/business\\/4-APPLIED\\/4-APPLIED-articleInline.jpg\",\n" +
            "            \"format\": \"Normal\",\n" +
            "            \"height\": 165,\n" +
            "            \"width\": 190,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"photo\",\n" +
            "            \"caption\": \"\",\n" +
            "            \"copyright\": \"Michael Waraksa\"\n" +
            "        }, {\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/04\\/business\\/4-APPLIED\\/4-APPLIED-mediumThreeByTwo210-v2.jpg\",\n" +
            "            \"format\": \"mediumThreeByTwo210\",\n" +
            "            \"height\": 140,\n" +
            "            \"width\": 210,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"photo\",\n" +
            "            \"caption\": \"\",\n" +
            "            \"copyright\": \"Michael Waraksa\"\n" +
            "        }]\n" +
            "    }, {\n" +
            "        \"section\": \"Business Day\",\n" +
            "        \"subsection\": \"Dealbook\",\n" +
            "        \"title\": \"Euro Falls Lower as Central Bank Hints at Increase in Stimulus Plan\",\n" +
            "        \"abstract\": \"Statements by Mario Draghi, president of the European Central Bank, led investors to conclude that the bank would soon buy large quantities of eurobonds.\",\n" +
            "        \"url\": \"http:\\/\\/dealbook.nytimes.com\\/2015\\/01\\/02\\/euro-falls-lower-as-central-bank-hints-at-increase-in-stimulus-plan\\/\",\n" +
            "        \"byline\": \"By LANDON THOMAS JR. and JACK EWING\",\n" +
            "        \"thumbnail_standard\": \"\",\n" +
            "        \"item_type\": \"Blog\",\n" +
            "        \"source\": \"The New York Times\",\n" +
            "        \"updated_date\": \"2015-01-02T19:59:54-05:00\",\n" +
            "        \"created_date\": \"2015-01-02T19:42:24-05:00\",\n" +
            "        \"published_date\": \"2015-01-02T00:00:00-05:00\",\n" +
            "        \"material_type_facet\": \"News\",\n" +
            "        \"kicker\": \"DealBook\",\n" +
            "        \"subheadline\": \"\",\n" +
            "        \"des_facet\": [\"Currency\", \"Deflation (Economics)\", \"Euro (Currency)\", \"US Dollar (Currency)\"],\n" +
            "        \"org_facet\": [\"European Central Bank\"],\n" +
            "        \"per_facet\": [\"Draghi, Mario\"],\n" +
            "        \"geo_facet\": [\"Europe\"],\n" +
            "        \"related_urls\": null,\n" +
            "        \"blog_name\": \"DealBook\",\n" +
            "        \"multimedia\": [{\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/02\\/business\\/dealbook\\/dbpix-draghi-euro\\/dbpix-draghi-thumbStandard.jpg\",\n" +
            "            \"format\": \"Standard Thumbnail\",\n" +
            "            \"height\": 75,\n" +
            "            \"width\": 75,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"photo\",\n" +
            "            \"caption\": \"\",\n" +
            "            \"copyright\": \"\"\n" +
            "        }]\n" +
            "    }, {\n" +
            "        \"section\": \"Business Day\",\n" +
            "        \"subsection\": \"Media\",\n" +
            "        \"title\": \"F.C.C. Sets Vote on Broadband Rules for February\",\n" +
            "        \"abstract\": \"President Obama has asked the F.C.C. to put service providers under the same rules as those imposed on telephone companies 80 years ago.\",\n" +
            "        \"url\": \"http:\\/\\/www.nytimes.com\\/2015\\/01\\/03\\/business\\/media\\/fcc-sets-vote-on-broadband-rules-for-february.html\",\n" +
            "        \"byline\": \"By THE ASSOCIATED PRESS\",\n" +
            "        \"thumbnail_standard\": \"\",\n" +
            "        \"item_type\": \"Article\",\n" +
            "        \"source\": \"The New York Times\",\n" +
            "        \"updated_date\": \"2015-01-03T02:03:14-05:00\",\n" +
            "        \"created_date\": \"2015-01-02T19:25:54-05:00\",\n" +
            "        \"published_date\": \"2015-01-03T00:00:00-05:00\",\n" +
            "        \"material_type_facet\": \"Brief\",\n" +
            "        \"kicker\": \"\",\n" +
            "        \"subheadline\": \"\",\n" +
            "        \"des_facet\": [\"Computers and the Internet\"],\n" +
            "        \"org_facet\": [\"Federal Communications Commission\"],\n" +
            "        \"per_facet\": [\"Wheeler, Thomas E\"],\n" +
            "        \"geo_facet\": \"\",\n" +
            "        \"related_urls\": null,\n" +
            "        \"multimedia\": \"\"\n" +
            "    }, {\n" +
            "        \"section\": \"Business Day\",\n" +
            "        \"subsection\": \"International Business\",\n" +
            "        \"title\": \"New Zealand Glaciers Ebb and Tour Guides Play Catch-Up\",\n" +
            "        \"abstract\": \"With winter weather more unpredictable in many parts of the world, companies offering tours through ice and snow find an uneven effect on business.\",\n" +
            "        \"url\": \"http:\\/\\/www.nytimes.com\\/2015\\/01\\/03\\/business\\/international\\/new-zealand-glaciers-ebb-and-tour-guides-play-catch-up.html\",\n" +
            "        \"byline\": \"By MIKE IVES\",\n" +
            "        \"thumbnail_standard\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/03\\/business\\/03GLACIER-1\\/03GLACIER-1-thumbStandard.jpg\",\n" +
            "        \"item_type\": \"Article\",\n" +
            "        \"source\": \"The New York Times\",\n" +
            "        \"updated_date\": \"2015-01-03T05:01:23-05:00\",\n" +
            "        \"created_date\": \"2015-01-02T18:42:46-05:00\",\n" +
            "        \"published_date\": \"2015-01-03T00:00:00-05:00\",\n" +
            "        \"material_type_facet\": \"News\",\n" +
            "        \"kicker\": \"\",\n" +
            "        \"subheadline\": \"\",\n" +
            "        \"des_facet\": [\"Environment\", \"Travel and Vacations\", \"Eco-Tourism\", \"Glaciers\"],\n" +
            "        \"org_facet\": \"\",\n" +
            "        \"per_facet\": \"\",\n" +
            "        \"geo_facet\": [\"New Zealand\"],\n" +
            "        \"related_urls\": null,\n" +
            "        \"multimedia\": [{\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/03\\/business\\/03GLACIER-1\\/03GLACIER-1-thumbStandard.jpg\",\n" +
            "            \"format\": \"Standard Thumbnail\",\n" +
            "            \"height\": 75,\n" +
            "            \"width\": 75,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"photo\",\n" +
            "            \"caption\": \"As glaciers retreat on South Island, getting to some of the popular sites requires a helicopter ride, no longer a hike.\",\n" +
            "            \"copyright\": \"Guy Frederick for The New York Times\"\n" +
            "        }, {\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/03\\/business\\/03GLACIER-1\\/03GLACIER-1-thumbLarge.jpg\",\n" +
            "            \"format\": \"thumbLarge\",\n" +
            "            \"height\": 150,\n" +
            "            \"width\": 150,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"photo\",\n" +
            "            \"caption\": \"As glaciers retreat on South Island, getting to some of the popular sites requires a helicopter ride, no longer a hike.\",\n" +
            "            \"copyright\": \"Guy Frederick for The New York Times\"\n" +
            "        }, {\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/03\\/business\\/03GLACIER-1\\/03GLACIER-1-articleInline.jpg\",\n" +
            "            \"format\": \"Normal\",\n" +
            "            \"height\": 125,\n" +
            "            \"width\": 190,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"photo\",\n" +
            "            \"caption\": \"As glaciers retreat on South Island, getting to some of the popular sites requires a helicopter ride, no longer a hike.\",\n" +
            "            \"copyright\": \"Guy Frederick for The New York Times\"\n" +
            "        }, {\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/03\\/business\\/03GLACIER-1\\/03GLACIER-1-mediumThreeByTwo210.jpg\",\n" +
            "            \"format\": \"mediumThreeByTwo210\",\n" +
            "            \"height\": 140,\n" +
            "            \"width\": 210,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"photo\",\n" +
            "            \"caption\": \"As glaciers retreat on South Island, getting to some of the popular sites requires a helicopter ride, no longer a hike.\",\n" +
            "            \"copyright\": \"Guy Frederick for The New York Times\"\n" +
            "        }, {\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/03\\/business\\/Glaciersjp1\\/Glaciersjp1-thumbStandard.jpg\",\n" +
            "            \"format\": \"Standard Thumbnail\",\n" +
            "            \"height\": 75,\n" +
            "            \"width\": 75,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"photo\",\n" +
            "            \"caption\": \"June Hurford, a bakery owner, wonders how the glaciers&rsquo; retreat will affect her tourist-dependent livelihood.\",\n" +
            "            \"copyright\": \"Guy Frederick for The New York Times\"\n" +
            "        }, {\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/03\\/business\\/Glaciersjp1\\/Glaciersjp1-thumbLarge.jpg\",\n" +
            "            \"format\": \"thumbLarge\",\n" +
            "            \"height\": 150,\n" +
            "            \"width\": 150,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"photo\",\n" +
            "            \"caption\": \"June Hurford, a bakery owner, wonders how the glaciers&rsquo; retreat will affect her tourist-dependent livelihood.\",\n" +
            "            \"copyright\": \"Guy Frederick for The New York Times\"\n" +
            "        }, {\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/03\\/business\\/Glaciersjp1\\/Glaciersjp1-articleInline.jpg\",\n" +
            "            \"format\": \"Normal\",\n" +
            "            \"height\": 134,\n" +
            "            \"width\": 190,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"photo\",\n" +
            "            \"caption\": \"June Hurford, a bakery owner, wonders how the glaciers&rsquo; retreat will affect her tourist-dependent livelihood.\",\n" +
            "            \"copyright\": \"Guy Frederick for The New York Times\"\n" +
            "        }, {\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/03\\/business\\/Glaciersjp1\\/Glaciersjp1-mediumThreeByTwo210.jpg\",\n" +
            "            \"format\": \"mediumThreeByTwo210\",\n" +
            "            \"height\": 140,\n" +
            "            \"width\": 210,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"photo\",\n" +
            "            \"caption\": \"June Hurford, a bakery owner, wonders how the glaciers&rsquo; retreat will affect her tourist-dependent livelihood.\",\n" +
            "            \"copyright\": \"Guy Frederick for The New York Times\"\n" +
            "        }, {\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/03\\/business\\/03SUBGLACIER-2\\/03SUBGLACIER-2-thumbStandard.jpg\",\n" +
            "            \"format\": \"Standard Thumbnail\",\n" +
            "            \"height\": 75,\n" +
            "            \"width\": 75,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"photo\",\n" +
            "            \"caption\": \"A tour guide in New Zealand. Tourism directly accounted for 3.7 percent of gross domestic product in the year ending March 31, 2013.\",\n" +
            "            \"copyright\": \"Guy Frederick for The New York Times\"\n" +
            "        }, {\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/03\\/business\\/03SUBGLACIER-2\\/03SUBGLACIER-2-thumbLarge.jpg\",\n" +
            "            \"format\": \"thumbLarge\",\n" +
            "            \"height\": 150,\n" +
            "            \"width\": 150,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"photo\",\n" +
            "            \"caption\": \"A tour guide in New Zealand. Tourism directly accounted for 3.7 percent of gross domestic product in the year ending March 31, 2013.\",\n" +
            "            \"copyright\": \"Guy Frederick for The New York Times\"\n" +
            "        }, {\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/03\\/business\\/03SUBGLACIER-2\\/03SUBGLACIER-2-articleInline.jpg\",\n" +
            "            \"format\": \"Normal\",\n" +
            "            \"height\": 127,\n" +
            "            \"width\": 190,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"photo\",\n" +
            "            \"caption\": \"A tour guide in New Zealand. Tourism directly accounted for 3.7 percent of gross domestic product in the year ending March 31, 2013.\",\n" +
            "            \"copyright\": \"Guy Frederick for The New York Times\"\n" +
            "        }, {\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/03\\/business\\/03SUBGLACIER-2\\/03SUBGLACIER-2-mediumThreeByTwo210.jpg\",\n" +
            "            \"format\": \"mediumThreeByTwo210\",\n" +
            "            \"height\": 140,\n" +
            "            \"width\": 210,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"photo\",\n" +
            "            \"caption\": \"A tour guide in New Zealand. Tourism directly accounted for 3.7 percent of gross domestic product in the year ending March 31, 2013.\",\n" +
            "            \"copyright\": \"Guy Frederick for The New York Times\"\n" +
            "        }, {\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/03\\/business\\/Glaciersjp2\\/Glaciersjp2-thumbStandard.jpg\",\n" +
            "            \"format\": \"Standard Thumbnail\",\n" +
            "            \"height\": 75,\n" +
            "            \"width\": 75,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"photo\",\n" +
            "            \"caption\": \"Rob Jewell, the chief executive of Fox Glacier Guiding, said the loss of hiking access since April had taken a &ldquo;significant&rdquo; toll on business.\",\n" +
            "            \"copyright\": \"Guy Frederick for The New York Times\"\n" +
            "        }, {\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/03\\/business\\/Glaciersjp2\\/Glaciersjp2-thumbLarge.jpg\",\n" +
            "            \"format\": \"thumbLarge\",\n" +
            "            \"height\": 150,\n" +
            "            \"width\": 150,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"photo\",\n" +
            "            \"caption\": \"Rob Jewell, the chief executive of Fox Glacier Guiding, said the loss of hiking access since April had taken a &ldquo;significant&rdquo; toll on business.\",\n" +
            "            \"copyright\": \"Guy Frederick for The New York Times\"\n" +
            "        }, {\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/03\\/business\\/Glaciersjp2\\/Glaciersjp2-articleInline.jpg\",\n" +
            "            \"format\": \"Normal\",\n" +
            "            \"height\": 137,\n" +
            "            \"width\": 190,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"photo\",\n" +
            "            \"caption\": \"Rob Jewell, the chief executive of Fox Glacier Guiding, said the loss of hiking access since April had taken a &ldquo;significant&rdquo; toll on business.\",\n" +
            "            \"copyright\": \"Guy Frederick for The New York Times\"\n" +
            "        }, {\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/03\\/business\\/Glaciersjp2\\/Glaciersjp2-mediumThreeByTwo210.jpg\",\n" +
            "            \"format\": \"mediumThreeByTwo210\",\n" +
            "            \"height\": 140,\n" +
            "            \"width\": 210,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"photo\",\n" +
            "            \"caption\": \"Rob Jewell, the chief executive of Fox Glacier Guiding, said the loss of hiking access since April had taken a &ldquo;significant&rdquo; toll on business.\",\n" +
            "            \"copyright\": \"Guy Frederick for The New York Times\"\n" +
            "        }]\n" +
            "    }, {\n" +
            "        \"section\": \"Business Day\",\n" +
            "        \"subsection\": \"Energy & Environment \",\n" +
            "        \"title\": \"Gasoline-Tax Increase Finds Little Support \",\n" +
            "        \"abstract\": \"Advocates like Senator Bob Corker of Tennessee find it tough to penetrate Washington\\u2019s antitax mood, even as gas prices fall and federal transportation funds face huge deficits.\",\n" +
            "        \"url\": \"http:\\/\\/www.nytimes.com\\/2015\\/01\\/03\\/business\\/energy-environment\\/support-for-gas-tax-increase-still-nil-despite-falling-prices.html\",\n" +
            "        \"byline\": \"By PATRICIA COHEN\",\n" +
            "        \"thumbnail_standard\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/03\\/business\\/Gastax1\\/Gastax1-thumbStandard.jpg\",\n" +
            "        \"item_type\": \"Article\",\n" +
            "        \"source\": \"The New York Times\",\n" +
            "        \"updated_date\": \"2015-01-04T09:38:42-05:00\",\n" +
            "        \"created_date\": \"2015-01-02T18:38:42-05:00\",\n" +
            "        \"published_date\": \"2015-01-03T00:00:00-05:00\",\n" +
            "        \"material_type_facet\": \"News\",\n" +
            "        \"kicker\": \"\",\n" +
            "        \"subheadline\": \"\",\n" +
            "        \"des_facet\": [\"Gasoline Tax (US)\"],\n" +
            "        \"org_facet\": [\"Energy Information Administration\", \"Senate\"],\n" +
            "        \"per_facet\": [\"Corker, Robert Phillips Jr\", \"Murphy, Christopher Scott\"],\n" +
            "        \"geo_facet\": \"\",\n" +
            "        \"related_urls\": null,\n" +
            "        \"multimedia\": [{\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/03\\/business\\/Gastax1\\/Gastax1-thumbStandard.jpg\",\n" +
            "            \"format\": \"Standard Thumbnail\",\n" +
            "            \"height\": 75,\n" +
            "            \"width\": 75,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"photo\",\n" +
            "            \"caption\": \"A gas station in Mississippi reflected sliding prices. The average price of regular gas has dropped under $2.50 a gallon, but in the antitax environment that pervades Washington there is still scant support for increasing the gas tax to finance upkeep of the nation&rsquo;s roadways and public transit systems.\",\n" +
            "            \"copyright\": \"Daniel Lin\\/The Enterprise-Journal, via Associated Press\"\n" +
            "        }, {\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/03\\/business\\/Gastax1\\/Gastax1-thumbLarge.jpg\",\n" +
            "            \"format\": \"thumbLarge\",\n" +
            "            \"height\": 150,\n" +
            "            \"width\": 150,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"photo\",\n" +
            "            \"caption\": \"A gas station in Mississippi reflected sliding prices. The average price of regular gas has dropped under $2.50 a gallon, but in the antitax environment that pervades Washington there is still scant support for increasing the gas tax to finance upkeep of the nation&rsquo;s roadways and public transit systems.\",\n" +
            "            \"copyright\": \"Daniel Lin\\/The Enterprise-Journal, via Associated Press\"\n" +
            "        }, {\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/03\\/business\\/Gastax1\\/Gastax1-articleInline.jpg\",\n" +
            "            \"format\": \"Normal\",\n" +
            "            \"height\": 129,\n" +
            "            \"width\": 190,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"photo\",\n" +
            "            \"caption\": \"A gas station in Mississippi reflected sliding prices. The average price of regular gas has dropped under $2.50 a gallon, but in the antitax environment that pervades Washington there is still scant support for increasing the gas tax to finance upkeep of the nation&rsquo;s roadways and public transit systems.\",\n" +
            "            \"copyright\": \"Daniel Lin\\/The Enterprise-Journal, via Associated Press\"\n" +
            "        }, {\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/03\\/business\\/Gastax1\\/Gastax1-mediumThreeByTwo210.jpg\",\n" +
            "            \"format\": \"mediumThreeByTwo210\",\n" +
            "            \"height\": 140,\n" +
            "            \"width\": 210,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"photo\",\n" +
            "            \"caption\": \"A gas station in Mississippi reflected sliding prices. The average price of regular gas has dropped under $2.50 a gallon, but in the antitax environment that pervades Washington there is still scant support for increasing the gas tax to finance upkeep of the nation&rsquo;s roadways and public transit systems.\",\n" +
            "            \"copyright\": \"Daniel Lin\\/The Enterprise-Journal, via Associated Press\"\n" +
            "        }, {\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/03\\/business\\/Gastax2\\/Gastax2-thumbStandard.jpg\",\n" +
            "            \"format\": \"Standard Thumbnail\",\n" +
            "            \"height\": 75,\n" +
            "            \"width\": 75,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"photo\",\n" +
            "            \"caption\": \"Senator Bob Corker, who has tried to appease deficit hawks by proposing to reduce other taxes in exchange for a rise in the gas tax, said his plan would probably get caught up in negotiations about broader tax reform.\",\n" +
            "            \"copyright\": \"Alex Wong\\/Getty Images\"\n" +
            "        }, {\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/03\\/business\\/Gastax2\\/Gastax2-thumbLarge.jpg\",\n" +
            "            \"format\": \"thumbLarge\",\n" +
            "            \"height\": 150,\n" +
            "            \"width\": 150,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"photo\",\n" +
            "            \"caption\": \"Senator Bob Corker, who has tried to appease deficit hawks by proposing to reduce other taxes in exchange for a rise in the gas tax, said his plan would probably get caught up in negotiations about broader tax reform.\",\n" +
            "            \"copyright\": \"Alex Wong\\/Getty Images\"\n" +
            "        }, {\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/03\\/business\\/Gastax2\\/Gastax2-articleInline.jpg\",\n" +
            "            \"format\": \"Normal\",\n" +
            "            \"height\": 129,\n" +
            "            \"width\": 190,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"photo\",\n" +
            "            \"caption\": \"Senator Bob Corker, who has tried to appease deficit hawks by proposing to reduce other taxes in exchange for a rise in the gas tax, said his plan would probably get caught up in negotiations about broader tax reform.\",\n" +
            "            \"copyright\": \"Alex Wong\\/Getty Images\"\n" +
            "        }, {\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/03\\/business\\/Gastax2\\/Gastax2-mediumThreeByTwo210.jpg\",\n" +
            "            \"format\": \"mediumThreeByTwo210\",\n" +
            "            \"height\": 140,\n" +
            "            \"width\": 210,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"photo\",\n" +
            "            \"caption\": \"Senator Bob Corker, who has tried to appease deficit hawks by proposing to reduce other taxes in exchange for a rise in the gas tax, said his plan would probably get caught up in negotiations about broader tax reform.\",\n" +
            "            \"copyright\": \"Alex Wong\\/Getty Images\"\n" +
            "        }]\n" +
            "    }, {\n" +
            "        \"section\": \"Business Day\",\n" +
            "        \"subsection\": \"Dealbook\",\n" +
            "        \"title\": \"Bitcoin Foundation Parts Ways With Its Global Policy Counsel\",\n" +
            "        \"abstract\": \"The dismissal of Jim Harper comes as the Bitcoin Foundation is shifting its focus, from policy advocacy to Bitcoin technology and infrastructure development.\",\n" +
            "        \"url\": \"http:\\/\\/dealbook.nytimes.com\\/2015\\/01\\/02\\/bitcoin-foundation-parts-ways-with-its-global-policy-counsel\\/\",\n" +
            "        \"byline\": \"By SYDNEY EMBER\",\n" +
            "        \"thumbnail_standard\": \"\",\n" +
            "        \"item_type\": \"Blog\",\n" +
            "        \"source\": \"The New York Times\",\n" +
            "        \"updated_date\": \"2015-01-02T17:38:03-05:00\",\n" +
            "        \"created_date\": \"2015-01-02T17:38:03-05:00\",\n" +
            "        \"published_date\": \"2015-01-02T00:00:00-05:00\",\n" +
            "        \"material_type_facet\": \"News\",\n" +
            "        \"kicker\": \"DealBook\",\n" +
            "        \"subheadline\": \"\",\n" +
            "        \"des_facet\": [\"Bitcoin (Currency)\", \"Law and Legislation\", \"Regulation and Deregulation of Industry\"],\n" +
            "        \"org_facet\": [\"Bitcoin Foundation\", \"Cato Institute\", \"MtGox Co Ltd\"],\n" +
            "        \"per_facet\": [\"Harper, Jim\", \"Murck, Patrick\", \"Wilson, Cody\"],\n" +
            "        \"geo_facet\": \"\",\n" +
            "        \"related_urls\": null,\n" +
            "        \"blog_name\": \"DealBook\",\n" +
            "        \"multimedia\": [{\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/03\\/business\\/dbpix-bitcoin\\/dbpix-bitcoin-thumbStandard.jpg\",\n" +
            "            \"format\": \"Standard Thumbnail\",\n" +
            "            \"height\": 75,\n" +
            "            \"width\": 75,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"photo\",\n" +
            "            \"caption\": \"\",\n" +
            "            \"copyright\": \"\"\n" +
            "        }]\n" +
            "    }, {\n" +
            "        \"section\": \"Business Day\",\n" +
            "        \"subsection\": \"Economy\",\n" +
            "        \"title\": \"U.S. Factories Expand at Slowest Pace in 6 Months, but Growth Is Still Healthy\",\n" +
            "        \"abstract\": \"December&#8217;s reading is also close to the average for all of 2014 and remains a solid figure.\",\n" +
            "        \"url\": \"http:\\/\\/www.nytimes.com\\/2015\\/01\\/03\\/business\\/economy\\/activity-at-us-factories-grows-at-slowest-pace-in-6-months.html\",\n" +
            "        \"byline\": \"By THE ASSOCIATED PRESS\",\n" +
            "        \"thumbnail_standard\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/03\\/business\\/Econ\\/Econ-thumbStandard.jpg\",\n" +
            "        \"item_type\": \"Article\",\n" +
            "        \"source\": \"The New York Times\",\n" +
            "        \"updated_date\": \"2015-01-03T02:06:14-05:00\",\n" +
            "        \"created_date\": \"2015-01-02T17:17:42-05:00\",\n" +
            "        \"published_date\": \"2015-01-03T00:00:00-05:00\",\n" +
            "        \"material_type_facet\": \"News\",\n" +
            "        \"kicker\": \"\",\n" +
            "        \"subheadline\": \"\",\n" +
            "        \"des_facet\": [\"United States Economy\", \"Factories and Manufacturing\", \"Labor and Jobs\"],\n" +
            "        \"org_facet\": [\"Wells Fargo & Company|WFC|NYSE\"],\n" +
            "        \"per_facet\": \"\",\n" +
            "        \"geo_facet\": \"\",\n" +
            "        \"related_urls\": null,\n" +
            "        \"multimedia\": [{\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/03\\/business\\/Econ\\/Econ-thumbStandard.jpg\",\n" +
            "            \"format\": \"Standard Thumbnail\",\n" +
            "            \"height\": 75,\n" +
            "            \"width\": 75,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"photo\",\n" +
            "            \"caption\": \"A worker assembling a travel trailer, usually built by hand, at the Airstream factory in Jackson Center, Ohio.\",\n" +
            "            \"copyright\": \"Jay Laprete\\/Associated Press\"\n" +
            "        }, {\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/03\\/business\\/Econ\\/Econ-thumbLarge.jpg\",\n" +
            "            \"format\": \"thumbLarge\",\n" +
            "            \"height\": 150,\n" +
            "            \"width\": 150,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"photo\",\n" +
            "            \"caption\": \"A worker assembling a travel trailer, usually built by hand, at the Airstream factory in Jackson Center, Ohio.\",\n" +
            "            \"copyright\": \"Jay Laprete\\/Associated Press\"\n" +
            "        }, {\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/03\\/business\\/Econ\\/Econ-articleInline.jpg\",\n" +
            "            \"format\": \"Normal\",\n" +
            "            \"height\": 138,\n" +
            "            \"width\": 190,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"photo\",\n" +
            "            \"caption\": \"A worker assembling a travel trailer, usually built by hand, at the Airstream factory in Jackson Center, Ohio.\",\n" +
            "            \"copyright\": \"Jay Laprete\\/Associated Press\"\n" +
            "        }, {\n" +
            "            \"url\": \"http:\\/\\/graphics8.nytimes.com\\/images\\/2015\\/01\\/03\\/business\\/Econ\\/Econ-mediumThreeByTwo210.jpg\",\n" +
            "            \"format\": \"mediumThreeByTwo210\",\n" +
            "            \"height\": 140,\n" +
            "            \"width\": 210,\n" +
            "            \"type\": \"image\",\n" +
            "            \"subtype\": \"photo\",\n" +
            "            \"caption\": \"A worker assembling a travel trailer, usually built by hand, at the Airstream factory in Jackson Center, Ohio.\",\n" +
            "            \"copyright\": \"Jay Laprete\\/Associated Press\"\n" +
            "        }]\n" +
            "    }]\n" +
            "}";

    public void testGetResult() {
        List<ResultContainer> containers = new NewsWire().getResultsUsesGson(testJsonStr);
        for (ResultContainer container : containers) {
            String titleStr = container.getTitle();
            String abstractStr = container.getAbstract();
            String urlStr = container.getUrl();
            String multimediaStr = container.getMultimediaUrl();
            Log.d("UnitTest", new StringBuilder("Values : ")
                    .append(titleStr + "\n")
                    .append(abstractStr + "\n")
                    .append(urlStr + "\n")
                    .append(multimediaStr + "\n").toString());
        }
        assertNotNull(containers);
    }
}

# News.java

##### &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;package com.mdsgpp.eef.model

## class News implements Serializable

#### Private members:

| Type                | Variable         | Description|
|---------------------|------------------|------------|
| `static final long` | serialVersionUID |
| `String`            | newsTitle        |Contain the title of news|
| `String`            | newsCategory     |Contain the category of news|
| `String`            | newsDescription  |Contain the description of news|
| `String`            | newsLink         |Contain the url to news|
| `String`            | newsDate         |Contain the date when news originated |
| `Feed`              | newsFeed         |Contain the feed related to news|

#### Public Members:

| Return Type |     Method Name    |         Arguments        |      Description     |
|:-----------:|:------------------:|:------------------------:|:--------------------:|
|             |        News        |      `Feed` newsFeed     | Standard constructor |
|   `String`  |    getNewsTitle    |            --            |                      |
|    `void`   |    setNewsTitle    |    `String` newsTitle    |                      |
|   `String`  |   getNewsCategory  |            --            |                      |
|    `void`   |   setNewsCategory  |   `String` newsCategory  |                      |
|   `String`  | getNewsDescription |            --            |                      |
|    `void`   | setNewsDescription | `String` newsDescription |                      |
|   `String`  |     getNewsLink    |            --            |                      |
|    `void`   |     setNewsLink    |     `String` newsLink    |                      |
|   `String`  |     getNewsDate    |            --            |                      |
|    `void`   |     setNewsDate    |     `String` newsDate    |                      |
|    `Feed`   |     getNewsFeed    |            --            |                      |

#### Local Variables per Function:

|        | Constructor |                                                         |
|:------:|:-----------:|:-------------------------------------------------------:|
|  Type  |   Variable  |                       Description                       |
| `Feed` |  `newsFeed` | Provides a value to be set on private member `newsFeed` |

|          | setNewsTitle |                                                          |
|:--------:|:------------:|:--------------------------------------------------------:|
|   Type   |   Variable   |                        Description                       |
| `String` |  `newsTitle` | Provides a value to be set on private member `newsTitle` |

|          | setNewsCategory |                                                             |
|:--------:|:---------------:|:-----------------------------------------------------------:|
|   Type   |     Variable    |                         Description                         |
| `String` |  `newsCategory` | Provides a value to be set on private member `newsCategory` |

|          | setNewsDescription |                                                                |
|:--------:|:------------------:|:--------------------------------------------------------------:|
|   Type   |      Variable      |                           Description                          |
| `String` |  `newsDescription` | Provides a value to be set on private member `newsDescription` |

|          | setNewsLink |                                                         |
|:--------:|:-----------:|:-------------------------------------------------------:|
|   Type   |   Variable  |                       Description                       |
| `String` |  `newsLink` | Provides a value to be set on private member `newsLink` |

|          | setNewsDate |                                                         |
|:--------:|:-----------:|:-------------------------------------------------------:|
|   Type   |   Variable  |                       Description                       |
| `String` |  `newsDate` | Provides a value to be set on private member `newsDate` |

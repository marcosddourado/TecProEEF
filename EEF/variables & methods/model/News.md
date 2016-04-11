# News.java

##### &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;package com.mdsgpp.eef.model

## class News implements Serializable

#### Private members:

| Type                | Variable         |
|---------------------|------------------|
| `static final long` | serialVersionUID |
| `String`            | newsTitle        |
| `String`            | newsCategory     |
| `String`            | newsDescription  |
| `String`            | newsLink         |
| `String`            | newsDate         |
| `Feed`              | newsFeed         |

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

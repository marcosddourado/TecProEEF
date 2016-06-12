# Feed.java

##### &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;package com.mdsgpp.eef.model

## class Feed implements Serializable

#### Private members:

| Type                |     Variable     | Description|
|---------------------|:----------------:|------------|
| `static final long` | serialVersionUID |            |
| `ArrayList<News>`   | feedItems        |`feedItems` will store all News  assigned to it's object|

#### Public members:
| Return Type |    Method Name   |       Arguments       |                     Description                    |
|:-----------:|:----------------:|:---------------------:|:--------------------------------------------------:|
|      --     |       Feed       |           --          |         Constructor. Initializes feedItems         |
| `ArrayList` |   getFeedItems   |           --          |                 Retrieve feedItems                 |
|    `News`   |    getFeedItem   |     `int` position    | Retrieve the item held by feedItems in  'position' |
|    `void`   |   setFeedItems   | `ArrayList` feedItems |  Set class member feedItems as argument feedItems  |
|    `void`   |    addFeedItem   |   `News` newFeedItem  |            Add newFeedItem to feedItems            |
|    `int`    | getFeedItemsSize |           --          |           Retrieve the size of feedItems           |
|    `void`   |       reset      |           --          |          Clear all Items held by feedItems         |

#### Local Variables per Function:


|       | Constructor |                                                                                 |
|:-----:|:-----------:|:-------------------------------------------------------------------------------:|
|  Type |   Variable  |                                   Description                                   |
| `int` |  `position` | `position`determines the position of a specific News item stored on `feedItems` |

|             | setFeedItems |                                                          |
|:-----------:|:------------:|:--------------------------------------------------------:|
|     Type    |   Variable   |                        Description                       |
| `ArrayList` |  `feedItems` | Provides a value to be set on private member `feedItems` |

|        |  addFeedItem  |                                                           |
|:------:|:-------------:|:---------------------------------------------------------:|
|  Type  |    Variable   |                        Description                        |
| `News` | `newFeedItem` | Provide a `New` item to be held by private membr feedIens |

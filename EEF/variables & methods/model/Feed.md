# Feed.java

##### &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;package com.mdsgpp.eef.model

## class Feed implements Serializable

#### Private members:

| Type                |     Variable     | Description|
|---------------------|:----------------:|------------|
| `static final long` | serialVersionUID |            |
| `ArrayList<News>`   | feedItens        |`feedItens` will store all News  assigned to it's object|

#### Public members:
| Return Type |    Method Name   |       Arguments       |                     Description                    |
|:-----------:|:----------------:|:---------------------:|:--------------------------------------------------:|
|      --     |       Feed       |           --          |         Constructor. Initializes feedItens         |
| `ArrayList` |   getFeedItens   |           --          |                 Retrieve feedItens                 |
|    `News`   |    getFeedItem   |     `int` position    | Retrieve the item held by feedItens in  'position' |
|    `void`   |   setFeedItens   | `ArrayList` feedItens |  Set class member feedItens as argument feedItens  |
|    `void`   |    addFeedItem   |   `News` newFeedItem  |            Add newFeedItem to feedItens            |
|    `int`    | getFeedItensSize |           --          |           Retrieve the size of feedItens           |
|    `void`   |       reset      |           --          |          Clear all itens held by feedItens         |

#### Local Variables per Function:


|       | Constructor |                                                                                 |
|:-----:|:-----------:|:-------------------------------------------------------------------------------:|
|  Type |   Variable  |                                   Description                                   |
| `int` |  `position` | `position`determines the position of a specific News item stored on `feedItens` |

|             | setFeedItens |                                                          |
|:-----------:|:------------:|:--------------------------------------------------------:|
|     Type    |   Variable   |                        Description                       |
| `ArrayList` |  `feedItens` | Provides a value to be set on private member `feedItens` |

|        |  addFeedItem  |                                                           |
|:------:|:-------------:|:---------------------------------------------------------:|
|  Type  |    Variable   |                        Description                        |
| `News` | `newFeedItem` | Provide a `New` item to be held by private membr feedIens |

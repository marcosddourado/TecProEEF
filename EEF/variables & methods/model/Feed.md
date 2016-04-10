# Feed.java

##### &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;package com.mdsgpp.eef.model

## class Feed implements Serializable

#### Private members:

| Type                |     Variable     |
|---------------------|:----------------:|
| `static final long` | serialVersionUID |
| `ArrayList<News>`   | feedItens        |

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
  * Feed()
    >Constructor. Initializes feedItens  

  * `ArrayList<News>` getFeedItens()

  * `News` getFeedItem(int position)
    >Retrieve the item held in position 'position'

  * `void` setFeedItens(ArrayList<News> feedItens)

  * `void` addFeedItem(`News` newFeedItem)
    >Add 'newFeedItem' to 'feedItens'

  * `int` getFeedItensSize()

  * `void` reset()
    >Clear all itens held by feedItens

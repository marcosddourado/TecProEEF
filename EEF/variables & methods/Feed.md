# Feed.java

##### &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;package com.mdsgpp.eef.model

## class Feed implements Serializable

#### Private members:

  * `static final long` serialVersionUID

  * `ArrayList<News>` feedItens

#### Public members:

  * Feed()
    >Constructor. Initializes feedItens  

  * `ArrayList<News>` getFeedItens()

  * `News` getFeedItem(int position)
    >Retrieve the item held in position 'position'

  * `void` setFeedItens(ArrayList<News> feedItens)

  * `void` addFeedItem(News newFeedItem)
    >Add 'newFeedItem' to 'feedItens'

  * `int` getFeedItensSize()

  * `void` reset()
    >Clear all itens held by feedItens

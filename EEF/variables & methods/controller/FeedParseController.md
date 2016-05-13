# FeedParseController.java

##### &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;package package com.mdsgpp.eef.controller

## class FeedParseController

#### Private members:

| Type     | Variable                     | Description                     |
|----------|------------------------------|---------------------------------|
| `Feed` | feed | Contains the feed attributes |
| `News` | item | Contains the news's informations |
| `static FeedParseController` | instance | Object of its own class |

#### Public members:

| Return Type | Method Name | Arguments | Description |
|:-----------:|:------------:|:---------:|:----------:|
|       | FeedParseController | -- | Standard constructor |
|`static FeedParseController` | getInstance | -- | Returns the object of the class |
|`Feed` | getFeed | -- | Returns the feed informations |
|`void` | createNewFeed | -- | Resets the current feed |
|`void` | createNewFeedItem | -- | Creates new informations on the feed |
|`News` | getItem | -- | Gets the news that are on the feed |

#### Local Variables per Function:

|          |          Constructor          |                                                   |
|:--------:|:-----------------------------:|:-------------------------------------------------:|
|   Type   |            Variable           |                    Description                    |
| `Context` | context                     | Contains the Activity that is calling this class |

|          |          getInstance          |                                                   |
|:--------:|:-----------------------------:|:-------------------------------------------------:|
|   Type   |            Variable           |                    Description                    |
| `Context` | context                     | Contains the Activity that is calling this class |

|          |          getInformations          |                                                   |
|:--------:|:-----------------------------:|:-------------------------------------------------:|
|   Type   |            Variable           |                    Description                    |
| `int` | position | Represents the index of a state in a Array |

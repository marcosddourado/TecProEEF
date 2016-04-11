# PersistenceFeed.java

##### &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;package package com.mdsgpp.eef.parse

## class PersistenceFeed

#### Private members:

| Type     | Variable                     | Description                     |
|----------|------------------------------|---------------------------------|
| `String` | FILENAME | The name of the file to be opened |
| `PersistenceFeed` | instance | An instance of the PersistenceFeed object to be initialized with the context |
| `Context` | context | The application's current context |

#### Public members:

| Return Type | Method Name | Arguments | Description |
|:-----------:|:------------:|:---------:|:----------:|
|      | PersistenceFeed | `Context` context | Constructor with initialization argument |
|`PersistenceFeed` | getInstance | `Context` context | Gets object current instance |
|`void` | writeFeedFile | `Feed` feed | Writes information from a certain feed |
|`Feed` | readFeedFile | -- | Reads information from a feed file that was previously saved |


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

#### Local variables per Function

|             | Constructor |           |
|:-----------:|:-----------:|:---------:|
| **Type** | **Variable** | **Description**|
| `Context` | context | The current context for the application. For more details, please refer to Android documentation. |

|             | Global Access Function (Singleton) |           |
|:-----------:|:-----------:|:---------:|
|  | This method has no local variables |  |

|             | writeFeedFile |           |
|:-----------:|:-----------:|:---------:|
| **Type** | **Variable** | **Description**|
| FileOutputStream | fileOutputStream | Data file handler. |
| ObjectOutputStream | out | Object manipulator for file handler object. |

|             | readFeedFile |           |
|:-----------:|:-----------:|:---------:|
| **Type** | **Variable** | **Description**|
| Feed | feed | A serializable object, used to perform data parsing. |
| FileInputStream | fileIn | A File object handler, used to open a file. |
| ObjectInputStream | in | An object handler to perform tasks on a file handler object. |
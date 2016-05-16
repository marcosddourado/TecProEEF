# ParseData.java

##### &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;package package com.mdsgpp.eef.parse

## class ParseData

#### Private members:

| Type     | Variable                     | Description                     |
|----------|------------------------------|---------------------------------|
| `HashMap<String, ArrayList<String[]>>` | informations | Object used to map parsed informations |
| `ArrayList<String[]>` | data | Raw parsed data |
| `Context` | context | Current application context |
| `String` | extension | File input extension |
| `String` | indicatorName | Name of the informtion indicator |
| `int` | lines | Number of lines on file |

#### Public members:

| Return Type | Method Name | Arguments | Description |
|:-----------:|:------------:|:---------:|:----------:|
|       | ParseData | `Context` context | Constructor with initialization argument |
|`HashMap<String, ArrayList<String[]>>` | getState | `int` position | Retrieves information about a particular state |
|`void` | eraseInformations | -- | Erases all information previously retrieved |
|`void` | eraseData | -- | Erases all parsed data |
|`void` | insertAcronymName |`String` name, `String` acronym | Sends state acronym and name through indicative's hashmap |
|`void` | readIndicatives | `BufferedReader` br | Reads the available information |

#### Local variables per Function

|  | Constructor |  |
|:-----------:|:------------:|:---------:|
| **Type** | **Variable** | **Description**|
| Context | context | The current context for the application. |

|  | getState |  |
|:-----------:|:------------:|:---------:|
| **Type** | **Variable** | **Description**|
| String | name | The state name. |
| String | acronym | The state's acronym. |
| AssetManager | am | An application assets handler. Used to get info about the state. |
| InputStream | is | A generic object input stream. |
| BufferedReader | br | An object used to read a data stream. |

|  | eraseInformations |  |
|:-----------:|:------------:|:---------:|
| **Type** | **Variable** | **Description**|
|  | Method has no local variables |  |

|  | eraseData |  |
|:-----------:|:------------:|:---------:|
| **Type** | **Variable** | **Description**|
|  | Method has no local variables |  |

|  | insertAcronymName |  |
|:-----------:|:------------:|:---------:|
| **Type** | **Variable** | **Description**|
| ArrayList<String[]> | container | Dictionary input value |
| String[] | nameAndAcronym | Dictionary input key |

|  | readIndicatives |  |
|:-----------:|:------------:|:---------:|
| **Type** | **Variable** | **Description**|
| String | line | Read file's current line |
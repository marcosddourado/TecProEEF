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

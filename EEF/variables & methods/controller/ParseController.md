# ParseController.java

##### &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;package package com.mdsgpp.eef.controller

## class ParseController

#### Private members:

| Type     | Variable                     | Description                     |
|----------|------------------------------|---------------------------------|
| `ParseController` | instance | Object of its own class |
| `DadosParse` | parser | DadosParse object that contains the States informations |

#### Public members:

| Return Type | Method Name | Arguments | Description |
|:-----------:|:------------:|:---------:|:----------:|
|       | ParseController | `Context` context | Constructor with initialization argument |
|`static ParseController` | getInstance | -- | Returns the object of the class |
|`HashMap<String, ArrayList<String[]>>` | getInformations | `int` position | Returns the informations of a specific State |

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

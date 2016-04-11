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

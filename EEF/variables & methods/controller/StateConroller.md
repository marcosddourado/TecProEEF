# StateConroller.java

##### &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;package package com.mdsgpp.eef.controller

## class StateConroller

#### Private members:

| Type     | Variable                     | Description                     |
|----------|------------------------------|---------------------------------|
| `StateConroller` | instance | Object of its own class |
| `Context` | context | Contains the Activity that is calling this class |
| `HashMap<String, String>` | stateInformations | List with the informations of a specif state |
| `HashMap<String, ArrayList<String[]>>` | parseInformations | Contains the information of a state that is comming from the ParseController |
| `DecimalFormat` | dfValue | Sets the decimal format for money values |
| `DecimalFormat` | dfPopulation | Sets the decimal format for population amounts |
| `DecimalFormat` | dfPercentage | Sets the decimal format for percentages |

#### Public members:

| Return Type | Method Name | Arguments | Description |
|:-----------:|:------------:|:---------:|:----------:|
|       | StateConroller | `Context` context | Constructor with initialization argument |
|`static StateConroller` | getInstance | -- | Returns the object of the class |
|`State` | grabState | `int` position | Returns a object of a specific State |
|`HashMap<String, String>` | readState | `int` position | Returns a HashMap with some informations of a specific state |
|`HashMap<String, String>` | readCompleteState | `int` position | Returns a HashMap with all the informations of a specific state |
|`void` | writeState | `State` state | Writes the information of a specific state in a HashMap |
|`void` | writeStateWithAllTheInformations | `State` state | Writes the all informations of a specific state in a HashMap |
|`void` | FillNameAbbreviationAndPopulation | `State` state | Sets the name, the abbreviation and the population of a specific state in a HashMap |

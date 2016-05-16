# MainActivity.java

##### &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;package package com.mdsgpp.eef.views

## class MainActivity

#### Protected members:

| Return Type | Method Name | Arguments | Description |
|:-----------:|:------------:|:---------:|:----------:|
| void | onCreate | `Bundle` savedInstanceState | Initializes the current activity |


#### Public members:

| Return Type | Method Name | Arguments | Description |
|:-----------:|:------------:|:---------:|:----------:|
|`boolean` | onCreateOptionsMenu | `Menu` menu | Initialize the contents of the Activity's standard options menu |
|`boolean` | onOptionsItemSelected | `MenuItem` item | It is called whenever an item in your options menu is selected |
|`void` | loadAboutScreen | -- | It is called whenever an item in your options menu is selected |
|`void` | clickButtonGeneralComparations | `View` view | Sets the action of the general comparation's button |
|`void` | clickButtonGeneralConsult | -- | Sets the action of the general consult's button |
|`void` | clickButtonFeed | -- | Sets the action of the feed's button |

#### Local Variables per Function:

|          |          onCreate          |                                                   |
|:--------:|:-----------------------------:|:-------------------------------------------------:|
|   Type   |            Variable           |                    Description                    |
| `Bundle` | savedInstanceState           | Activities have the ability, under special circumstances, to restore themselves to a previous state using the data stored in this bundle. If there is no available instance data, the savedInstanceState will be null. For example, the savedInstanceState will always be null the first time an Activity is started, but may be non-null if an Activity is destroyed during rotation. |

|          |          onCreateOptionsMenu  |                                                   |
|:--------:|:-----------------------------:|:-------------------------------------------------:|
|   Type   |            Variable           |                    Description                    |
| `Menu` | menu | Object that represents the menu on the current screen that is open on the app |

|          | onOptionsItemSelected |                                                   |
|:--------:|:-----------------------------:|:-------------------------------------------------:|
|   Type   |            Variable           |                    Description                    |
| `MenuItem` | item | Contains attributes of the item that was clicked on the menu |

|          | onRadioButtonClicked |                                                   |
|:--------:|:-----------------------------:|:-------------------------------------------------:|
|   Type   |            Variable           |                    Description                    |
| `View` | view | Contains attributes that can manipulates the current view on the current screen |

|          | setValues |                                                   |
|:--------:|:-----------------------------:|:-------------------------------------------------:|
|   Type   |            Variable           |                    Description                    |
| `String` | indicative | contains the name of the indicative that will be shown on the screen|
| `String` | tittle | contains the name of the tittle that will be shown on the screen|

|          |          onCreateOptionsMenu  |                                                   |
|:--------:|:-----------------------------:|:-------------------------------------------------:|
|   Type   |            Variable           |                    Description                    |
| `Menu` | menu | Object that represents the menu on the current screen that is open on the app |

|          | onOptionsItemSelected |                                                   |
|:--------:|:-----------------------------:|:-------------------------------------------------:|
|   Type   |            Variable           |                    Description                    |
| `MenuItem` | item | Contains attributes of the item that was clicked on the menu |

|          | loadAboutScreen |                                                   |
|:--------:|:-----------------------------:|:-------------------------------------------------:|
|   Type   |            Variable           |                    Description                    |
| `Intent` | intent | Sets the action to go from a Activity to another |

|          | clickButtonGeneralComparations |                                                   |
|:--------:|:-----------------------------:|:-------------------------------------------------:|
|   Type   |            Variable           |                    Description                    |
| `View` | view | Contains attributes that can manipulates the current view on the current screen |
| `Intent` | intent | Sets the action to go from a Activity to another |

|          | clickButtonGeneralConsult |                                                   |
|:--------:|:-----------------------------:|:-------------------------------------------------:|
|   Type   |            Variable           |                    Description                    |
| `View` | view | Contains attributes that can manipulates the current view on the current screen |
| `Intent` | intent | Sets the action to go from a Activity to another |

|          | clickButtonFeed |                                                   |
|:--------:|:-----------------------------:|:-------------------------------------------------:|
|   Type   |            Variable           |                    Description                    |
| `View` | view | Contains attributes that can manipulates the current view on the current screen |
| `Intent` | intent | Sets the action to go from a Activity to another |

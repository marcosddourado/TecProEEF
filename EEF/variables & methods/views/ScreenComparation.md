# ScreenComparation.java

##### &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;package package com.mdsgpp.eef.views

## class ScreenComparation

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
|`void` | clickButtonGeneralComparation | `View` view | Sets the action of the general comparation's button |
\

#### Local Variables per Function:

|          |          onCreate          |                                                   |
|:--------:|:-----------------------------:|:-------------------------------------------------:|
|   Type   |            Variable           |                    Description                    |
| `Bundle` | savedInstanceState           | Activities have the ability, under special circumstances, to restore themselves to a previous state using the data stored in this bundle. If there is no available instance data, the savedInstanceState will be null. For example, the savedInstanceState will always be null the first time an Activity is started, but may be non-null if an Activity is destroyed during rotation. |
| `Intent` | intent | Sets the action to go from a Activity to another |

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

|          | clickButtonAboutComparation |                                                   |
|:--------:|:-----------------------------:|:-------------------------------------------------:|
|   Type   |            Variable           |                    Description                    |
| `View` | view | Contains attributes that can manipulates the current view on the current screen |
| `Intent` | intent | Sets the action to go from a Activity to another |

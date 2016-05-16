# Comparation.java

##### &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;package package com.mdsgpp.eef.views

## class Comparation

#### Private members:

| Type     | Variable                     | Description                     |
|----------|------------------------------|---------------------------------|
| `Spinner` | statesSpinner01 | It is a list of the states |
| `Spinner` | statesSpinner | It is a list of the states |
| `ArrayAdapter<String>` | statesAdapter01 | Adapter of the states to generate a listview |
| `ArrayAdapter<String>` | statesAdapter02 | Adapter of the states to generate a listview  |
| `ArrayList<String>` | states01 | List of states |
| `ArrayList<String>` | states02 | List of states |
| `ArrayList<String>` | allStates | List of all states |

#### Protected members:

| Return Type | Method Name | Arguments | Description |
|:-----------:|:------------:|:---------:|:----------:|
| void | onCreate | `Bundle` savedInstanceState | Initializes the current activity |
|`boolean` | onCreateOptionsMenu | `Menu` menu | Initialize the contents of the Activity's standard options menu |


#### Public members:

| Return Type | Method Name | Arguments | Description |
|:-----------:|:------------:|:---------:|:----------:|
| `void` | inicializeSpinners | -- | Initialize both spinners |
|`void` | setAdapterSpinner01 | -- | Set the list of states without one of the states that is being shown on the other spinner |
|`void` | setAdapterSpinner02 | -- | Set the list of states without one of the states that is being shown on the other spinner |
|`ArrayList<String>` | fillStates | `ArrayList<String>` states | Fills the array with all the states |
|`void` | refreshValuesSpinnerWithoutTheStateOnTheSecondSpinner | `String` name | Refresh the values on the spinner if the user choose another state on the other spinner |
|`void` | refreshValuesSpinner | `String` name | Refresh the values on the spinner if the user choose another state on the other spinner |
|`abstract void` | clickButtonStatesComparation | `View` view | Sets the action on the comparation button |
|`Spinner` | getStatesSpinner01 | -- | Gets the states that are being shown on the Spinner01 |
|`Spinner` | getStatesSpinner | -- | Gets the states that are being shown on the Spinner |
|`ArrayList<String>` | getAllEstates | -- | Returns a list with all the states |


#### Local Variables per Function:

|          |          onCreate          |                                                   |
|:--------:|:-----------------------------:|:-------------------------------------------------:|
|   Type   |            Variable           |                    Description                    |
| `Bundle` | savedInstanceState           | Activities have the ability, under special circumstances, to restore themselves to a previous state using the data stored in this bundle. If there is no available instance data, the savedInstanceState will be null. For example, the savedInstanceState will always be null the first time an Activity is started, but may be non-null if an Activity is destroyed during rotation. |

|          |          onCreateOptionsMenu  |                                                   |
|:--------:|:-----------------------------:|:-------------------------------------------------:|
|   Type   |            Variable           |                    Description                    |
| `Menu` | menu | Object that represents the menu on the current screen that is open on the app |

|          |          fillStates  |                                                   |
|:--------:|:-----------------------------:|:-------------------------------------------------:|
|   Type   |            Variable           |                    Description                    |
| `ArrayList<String>` | states | Will be filled with the name of all the Brazilian states |

|          | refreshValuesSpinnerWithoutTheStateOnTheSecondSpinner  |                                                   |
|:--------:|:-----------------------------:|:-------------------------------------------------:|
|   Type   |            Variable           |                    Description                    |
| `String` | name | Will be filled with the name of all the Brazilian states |

|          | refreshValuesSpinnerWithoutTheStateOnTheFirstSpinner  |                                                   |
|:--------:|:-----------------------------:|:-------------------------------------------------:|
|   Type   |            Variable           |                    Description                    |
| `String` | name | Will be filled with the name of all the Brazilian states |

|          | clickButtonStatesComparation  |                                                   |
|:--------:|:-----------------------------:|:-------------------------------------------------:|
|   Type   |            Variable           |                    Description                    |
| `View` | view | Contains attributes that can manipulates the current view on the current screen |

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
|`void` | refreshValuesSpinner01 | `String` name | Refresh the values on the spinner if the user choose another state on the other spinner |
|`void` | refreshValuesSpinner02 | `String` name | Refresh the values on the spinner if the user choose another state on the other spinner |
|`abstract void` | clickButtonStatesComparation | `View` view | Sets the action on the comparation button |
|`Spinner` | getStatesSpinner01 | -- | Gets the states that are being shown on the Spinner01 |
|`Spinner` | getStatesSpinner | -- | Gets the states that are being shown on the Spinner |
|`ArrayList<String>` | getAllEstates | -- | Returns a list with all the states |

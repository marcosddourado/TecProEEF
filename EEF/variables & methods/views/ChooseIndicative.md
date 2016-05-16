# ChooseIndicative.java

##### &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;package package com.mdsgpp.eef.views

## class ChooseIndicative

#### Private members:

| Type     | Variable                     | Description                     |
|----------|------------------------------|---------------------------------|
| `String` | indicative | Contains the indicative of a state that the user wants to see |
| `String` | tittle | Contains the name of the indicative that the user wants to see |


#### Protected members:

| Return Type | Method Name | Arguments | Description |
|:-----------:|:------------:|:---------:|:----------:|
| void | onCreate | `Bundle` savedInstanceState | Initializes the current activity |
|`boolean` | onCreateOptionsMenu | `Menu` menu | Initialize the contents of the Activity's standard options menu |
|`boolean` | onOptionsItemSelected | `MenuItem` item | It is called whenever an item in your options menu is selected |


#### Public members:

| Return Type | Method Name | Arguments | Description |
|:-----------:|:------------:|:---------:|:----------:|
| abstract void | loadAboutScreen | -- | Opens a screen with the information about that Activity |
|`void` | onRadioButtonClicked | `View` view | Gets the information that the user wants to see depending on the radio button that the user selected|
|`void` | setValues | `String` indicative, `String` tittle | Sets the tittle and the indicative that the users wants to see, then they can be gotten in a Activity |
|` abstract void` | clickButtonNext | `View` view | Sets the action of the next button |
|`String` | getIndicative | -- | Returns the name of the indicative |
|`void` | setIndicative | -- | Sets the name of the indicative |
|`String` | getTittle | -- | Returns the tittle |
|`void` | setTittle | `String` tittle | Sets the tittle |

# ScreenQueryResultPerIndicative.java

##### &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;package com.mdsgpp.eef.views

## class ScreenQueryResultPerIndicative

#### Private members:

| Type     | Variable                     | Description                     |
|----------|------------------------------|---------------------------------|
| `Context` | context | Reference to this object. |
| `ListView` | stateList | A view which lists the queried states. |

| Return Type | Method Name | Arguments | Description |
|:-----------:|:-----------:|:---------:|:-----------:|
|   `void`    |  loadStateIndicatives   | | Loads information into the `stateList` view. |

#### Protected members:

| Return Type | Method Name | Arguments | Description |
|:-----------:|:-----------:|:---------:|:-----------:|
|   `void`    |  onCreate   | `Bundle` savedInstanceState | Initializes the current activity. |

#### Public members:

| Return Type | Method Name | Arguments | Description |
|:-----------:|:-----------:|:---------:|:-----------:|
|  `boolean`  |  onCreateOptionsMenu   | `Menu` menu | Inflate the menu and adds items to the action bar if it is present. |
|  `boolean`  |  onOptionsItemSelected   | `MenuItem` item | Treats the selection interaction of the current activity. |
|   `void`    |  initializeViews   | | Initializes the `stateList` view. |

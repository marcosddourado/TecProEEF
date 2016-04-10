# FeedController.java

##### &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;package package com.mdsgpp.eef.controller

## class FeedController

#### Private members:

| Type     | Variable                     | Description                     |
|----------|------------------------------|---------------------------------|
| `Context` | context                     | Contains the Activity that is calling this class |
| `boolean` | updated                     | Tells if the feed is updated or not |
| `DataReceiver` | dataReceiver           | Receives the feed data |
| `ProgressDialog` | progressBar          | The progress bar that shows how much of the data was downloaded already |

#### Protected members:

| Return Type | Method Name | Arguments | Description |
|:-----------:|:------------:|:---------:|:----------:|
|       | FeedController |`Context` context, `DataReceiver` dataReceiver| Constructor with initialization arguments|
|`void` | onPreExecute | -- | Creates the progress bar while the feed is being downloaded |
|`Feed` | doInBackground | `String...` url | Downloads the feed from the URL and writes it in a local file |
|`void` | onPostExecute | `Feed` feed | Dismiss the progress bar or shows an error message to the user |

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

#### Local Variables per Function:

|          |          Constructor          |                                                   |
|:--------:|:-----------------------------:|:-------------------------------------------------:|
|   Type   |            Variable           |                    Description                    |
| `Context` | context                     | Contains the Activity that is calling this class |
| `double` | `double finalElementaryYears` |  Provides a value to be set on private member `finalElementaryYears` |
| `DataReceiver` | dataReceiver           | Receives the feed data |

|          |          doInBackground          |                                                |
|:--------:|:-----------------------------:|:-------------------------------------------------:|
|   Type   |            Variable           |                    Description                    |
| `String...` | urls                     | Array that contains the informations of the URL |
| `URL` | url | Contains the URL that has the feed informations |
| `ParserFeed` | handler| Object that will return the Feed's informations |
| `InputStream` | is | Contains a stream of the URL |

|          |          onPostExecute          |                                                 |
|:--------:|:-----------------------------:|:-------------------------------------------------:|
|   Type   |            Variable           |                    Description                    |
| `Feed` | feed | Object with the informations of the Feed |

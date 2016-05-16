# ParserFeed.java

##### &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;package package com.mdsgpp.eef.parse

## class ParserFeed

#### Private members:

| Type     | Variable                     | Description                     |
|----------|------------------------------|---------------------------------|
| -- | -- | -- |


#### Public members:

| Return Type | Method Name | Arguments | Description |
|:-----------:|:------------:|:---------:|:----------:|
| `Feed` | parse | `InputStream` is | Treats `xml` file to be parsed by the application |

#### Local variables per Function

|  | Constructor |  |
|:-----------:|:------------:|:---------:|
| **Type** | **Variable** | **Description**|
| RootElement | root | The container element for the stored data. |
| Element | chanElement | The feed channel. |
| Element | chanItem | The item stored on the feed channel. |
| Element | itemTitle | The stored item's title. |
| Element | itemDescription | The stored item's description. |
| Element | itemCategory | The stored item's category. |
| Element | itemPubDate | The stored item's publication date. |
| Element | itemLink | The stored item's obtention link. |
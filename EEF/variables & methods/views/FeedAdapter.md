# FeedAdapter.java

##### &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;package package com.mdsgpp.eef.views

## class FeedAdapter

#### Private members:

| Type     | Variable                     | Description                     |
|----------|------------------------------|---------------------------------|
| `LayoutInflater` | mInflater | Inflates the Feed layout on a listview |
| `Feed` | feed | Object that contains Feed informations that will be shown on the list |
| `ViewHolder` | holder | Adapter of the states to generate a listview |
| `TextView` | tvTitle | Manipulates the TextView that shows the tittle |
| `TextView` | tvCategory | Manipulates the TextView that shows the category |
| `TextView` | tvDescription | Manipulates the TextView that shows the description of the feed |
| `static int` | DEFAULT_VALUE | Returns a default value of the items id |

#### Public members:

| Return Type | Method Name | Arguments | Description |
|:-----------:|:------------:|:---------:|:----------:|
|  | FeedAdapter | `Context` context, `Feed` feed | Standard constructor |
| `int` | getCount | -- | Returns the amount of items on the feed |
| `Object` | getItem | `int` position | Returns an item on the feed list |
| `long` | getItemId | `int` position | Returns a default value for the item id |
| `View` | getView | `int` position, `View` convertView, `ViewGroup` parent | Sets values on the list |


#### Local Variables per Function:

|          |          Constructor          |                                                   |
|:--------:|:-----------------------------:|:-------------------------------------------------:|
|   Type   |            Variable           |                    Description                    |
| `Context` | context                     | Contains the Activity that is calling this class |
| `Feed` | feed                     | Object that contains informations of the feed |

|          |          getItem          |                                                   |
|:--------:|:-----------------------------:|:-------------------------------------------------:|
|   Type   |            Variable           |                    Description                    |
| `int` | position                     | It is the position of an specific item on the list |

|          |          getItemId          |                                                   |
|:--------:|:-----------------------------:|:-------------------------------------------------:|
|   Type   |            Variable           |                    Description                    |
| `int` | position                     | It is the position of an specific item on the list |

|          |          getView          |                                                   |
|:--------:|:-----------------------------:|:-------------------------------------------------:|
|   Type   |            Variable           |                    Description                    |
| `int` | position                     | It is the position of an specific item on the list |
| `View` | convertView                     | Object that contains the attributes of the current Activity |
| `ViewGroup` | parent                     | Object that contains the attributes of the listview |

# IndicativeAdapter.java

##### &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;package package com.mdsgpp.eef.views

## class IndicativeAdapter

#### Private members:

| Type     | Variable                     | Description                     |
|----------|------------------------------|---------------------------------|
| `HashMap<String, String>` | state | HashMap with the informations of a specif state |
| `String` | choosedIndicative | Contains the indicative of a state that will be shown  |
| `String` | tittle | Contains the value that will be set on the tittle |
| `Context` | context | Manipulates the TextView that shows the tittle |
| `ViewHolder` | holder | Manipulates the TextView that shows the category |
| `LayoutInflater` | inflater | Manipulates the TextView that shows the description of the feed |

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

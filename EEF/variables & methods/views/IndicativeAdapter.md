# IndicativeAdapter.java

##### &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;package package com.mdsgpp.eef.views

## class IndicativeAdapter

#### Private members:

| Type     | Variable                     | Description                     |
|----------|------------------------------|---------------------------------|
| `static final int` | AMOUNT_OF_STATES | Contains the amount of states on Brazil |
| `static final int` | INDICATIVE | Represents the number of the array's index that contains the indicative of an state |
| `static final int` | STATE_VALUES | Represents the number of the array's index that contains the values related to an state |
| `HashMap<String, String>` | state | HashMap with the informations of a specif state |
| `String` | choosedIndicative | Contains the indicative of a state that will be shown  |
| `String` | tittle | Contains the value that will be set on the tittle |
| `Context` | context | Contains the Activity that is calling this class |
| `ViewHolder` | holder | Manipulates the TextView that shows the category |
| `LayoutInflater` | inflater | Manipulates the TextView that shows the description of the feed |
| `String` | flags | Array with the name of all the Brazilian states |
| `TextView` | tvName | Manipulates the TextView that shows the state's name |
| `TextView` | tvIndicativeValue | Manipulates the TextView that shows the indicative of a state |
| `ImageView` | tvFlags | Manipulates the ImageView that contains a flag of an specific state |

#### Public members:

| Return Type | Method Name | Arguments | Description |
|:-----------:|:------------:|:---------:|:----------:|
|  | IndicativeAdapter | `String` tittle, `String` selectedIndicative, `Context` context | Constructor with initialization arguments |
| `int` | getCount | -- | Returns the amount of items on the feed |
| `HashMap<String, String>` | getItem | `int` position | Returns an item on the state list |
| `long` | getItemId | `int` position | Returns a default value for the item id |
| `View` | getView | `int` position, `View` convertView, `ViewGroup` parent | Sets values on the list |
| `String` | getValue | `String` line | returns a value of a specific state that is stored in a file |


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

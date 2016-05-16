# ScreenConsultedIndicative.java

##### &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;package com.mdsgpp.eef.views

## class ScreenConsultedIndicative

#### Private members

| Type     | Variable                     | Description                     |
|----------|------------------------------|---------------------------------|
| `CheckBox` | cbIdeb | Represents whether the Ideb data are shown |
| `CheckBox` | cbPib | Represents whether the PIB data are shown |
| `CheckBox` | cbPopulation | Represents whether the population data are shown |
| `CheckBox` | cbFirstProjects | Represents whether the first projects data are shown |
| `CheckBox` | cbProjectsCnpq | Represents whether the CNPQ data are shown |
| `CheckBox` | cbProjectsDiffusion | Represents whether the diffusion data are shown |
| `CheckBox` | cbProjectsInitiation | Represents whether the initiation data are shown |
| `CheckBox` | cbProjectsYoung | Represents whether the young projects data are shown |
| `CheckBox` | cbProjectsCensus | Represents whether the census data are shown |
| `CheckBox` | cbProjectsClassStudents | Represents whether the class students data are shown |
| `CheckBox` | cbProjectsClassTime | Represents whether the class time data are shown |   
| `CheckBox` | cbProjectsDistortionRate | Represents whether the distortion rate data are shown |
| `CheckBox` | cbProjectsAbandonRate | Represents whether the abandon rate data are shown |
| `CheckBox` | cbProjectsApproval | Represents whether the approval data are shown |
| `boolean` | bIdeb | Represents the checkbox value of the Ideb data |
| `boolean` | bPib | Represents the checkbox value of the PIB data |
| `boolean` | bPopulation | Represents the checkbox value of the population data |
| `boolean` | bFirstProjects | Represents the checkbox value of the first projects data |
| `boolean` | bProjectsCnpq | Represents the checkbox value of the CNPQ data |
| `boolean` | bProjectsDiffusion | Represents the checkbox value of the diffusion data |
| `boolean` | bProjectsInitiation | Represents the checkbox value of the initiation data |
| `boolean` | bProjectsYoung | Represents the checkbox value of the young projects data |
| `boolean` | bProjectsCensus | Represents the checkbox value of the census data |
| `boolean` | bProjectsClassStudents | Represents the checkbox value of the class students data |
| `boolean` | bProjectsClassTime | Represents the checkbox value of the class time data |   
| `boolean` | bProjectsDistortionRate | Represents the checkbox value of the distortion rate data |
| `boolean` | bProjectsAbandonRate | Represents the checkbox value of the abandon rate data |
| `boolean` | bProjectsApproval | Represents the checkbox value of the approval data |
| `int` | position01 |  |
| `int` | position02 |  |

| Return Type | Method Name |   Arguments   |   Description     |
|-------------|-------------|---------------|-------------------|
|   `void`    | initializeCheckBox |        | Initializes the checkbox attributes |
|   `void`    |    captureValues   |        | Marks the boolean attribute flags as true or false, according to the checkboxes values |

#### Protected members:

| Return Type | Method Name | Arguments | Description |
|:-----------:|:-----------:|:---------:|:-----------:|
|   `void`    |  onCreate   | `Bundle` savedInstanceState | Initializes the current activity. |

#### Public members:

| Return Type | Method Name | Arguments | Description |
|:-----------:|:-----------:|:---------:|:-----------:|
|  `boolean`  |  onCreateOptionsMenu   | `Menu` menu | Inflate the menu and adds items to the action bar if it is present. |
|  `boolean`  |  onOptionsItemSelected   | `MenuItem` item | Treats the selection interaction of the current activity. |
| `void` | loadAboutScreen | | Opens the description screen. |
| `void` | checkBoxValueChanged | `boolean` value | Sets `value` to the selected attribute of all the checkboxes. |
| `void` | onRadioButtonMarcarTodosClicked | `View` view | Checks all the checkboxes |
| `void` | onRadioButtonDesmarcarTodosClicked | `View` view | Unchecks all the checkboxes |
| `void` | allIndicativesButtonTouch | `View` view | Callback to the all indicatives button touch. Shows `ScreenQueryResult` screen. |



#### Local Variables per Function:

|          |          onCreate         |                                                   |
|:--------:|:-------------------------:|:-------------------------------------------------:|
|   Type   |          Variable         |                    Description                    |
| `Intent` |  `intentAuxiliar` | The current activitiy's intent. Used for getting information.  |

|          |      loadAboutScreen      |                                                   |
|:--------:|:-------------------------:|:-------------------------------------------------:|
|   Type   |          Variable         |                    Description                    |
| `Intent` |  `intent` | The about screen's intent. Used for presenting the about screen.  |

|          | allIndicativesButtonTouch |                                                   |
|:--------:|:-------------------------:|:-------------------------------------------------:|
|   Type   |          Variable         |                    Description                    |
| `Intent` |  `intent` | New intent used for presenting ScreenQueryResult screen.  |

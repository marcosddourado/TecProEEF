# ScreenConsultedIndicative.java

##### &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;package com.mdsgpp.eef.views

## class ScreenConsultedIndicative

#### Private members

| Type     | Variable                     | Description                     |
|----------|------------------------------|---------------------------------|
| int | position1 | Screen position setting |
| int | position2 | Screen position setting |
| boolean | bCensus | Census availability. |
| boolean | bStudentsClass | Students Class availability. |
| boolean | bHoursClass | Class Hours availability. |
| boolean | bDistortionRate | Distortion rate availability. |
| boolean | bDropoutRate | Dropout rate availability. |
| boolean | bApproval | Approval rate availability. |
| boolean | bIdeb | Ideb index availability. |
| boolean | bPib | PIB index availability. |
| boolean | bPopulation | Population data availability. |
| boolean | bPrimeirosProjetos | First projects data availability. |
| boolean | bCnpqProjects | Cnpq projects data availability. |
| boolean | bDiffusionProjects | Diffusion projects data availability. |
| boolean | bInitiationProjects | Initiation projects data availability. |
| boolean | bJovensProject | Teen projects data availability. |
| RadioButton | rbIdebIniciais | Radio button selector |
| RadioButton | rbIdebFinals | Radio button selector |
| RadioButton | rbAverageIdeb | Radio button selector |
| RadioButton | rbPib | Radio button selector |
| RadioButton | rbPopulation |  Radio button selector |
| RadioButton | bPrimeirosProjetosQuantity| 	 Radio button selector |
| RadioButton | bPrimeirosProjetosValues| Radio button selector |
| RadioButton | rbCnpqProjectsQuantity| Radio button selector |
| RadioButton | rbCnpqProjectsValues| Radio button selector |
| RadioButton | rbDiffusionProjectsQuantity| Radio button selector |
| RadioButton | rbDiffusionProjectsValues| Radio button selector |
| RadioButton | rbInitiationProjectsQuantity| Radio button selector |
| RadioButton | rbInitiationProjectsValues| Radio button selector |
| RadioButton | rbJovensProjectQuantity| Radio button selector |
| RadioButton | rbJovensProjectValues| Radio button selector |
| RadioButton | rbStudentsClassElementary| Radio button selector |
| RadioButton | rbStudentsClassHighSchool| Radio button selector |
| RadioButton | rbHoursClassElementary| Radio button selector |
| RadioButton | rbHoursClassHighSchool| Radio button selector |
| RadioButton | rbDistortionRateElementary| Radio button selector |
| RadioButton | rbDistortionRateHighSchool| Radio button selector |
| RadioButton | rbApprovalRateElementary| Radio button selector |
| RadioButton | rbApprovalRateHighSchool| Radio button selector |
| RadioButton | rbDropoutRateElementary| Radio button selector |
| RadioButton | rbDropoutRateHighSchool| Radio button selector |
| RadioButton | rbCensusInitialYearsElementary| Radio button selector |
| RadioButton | rbCensusFinallYearsElementary| Radio button selector |
| RadioButton | rbCensusHighSchool| Radio button selector |
| RadioButton | rbCensusEJAElementary| Radio button selector |
| RadioButton | rbCensusEJAHighSchool| Radio button selector |

#### Protected Members

| Return Type | Method Name |   Arguments   |   Description     |
|-------------|-------------|---------------|-------------------|
|   `void`    | onCreate | `Bundle` savedInstance | Handles view creation specific tasks |

#### Public members

| Return Type | Method Name | Arguments | Description |
|:-----------:|:-----------:|:---------:|:-----------:|
|  `void`  |  setVisibility   | `RadioButton` radioButton, `boolean` visibility | changes visibility of a radio button. |
|  `void`  |  hideRadioButtons   |  | Hides all radio buttons. |
| `void` | getInformation | | Retrieves an information hashmap to populate fields. |
| `void` | initializeRadioButtons |  | Initializes all radio buttons. |
| `void` | clickButtonNext | `View` view | Starts a new activity. |
| `void` | loadAboutScreen |  | Opens the `about` section. |

#### Local Variables per Function

|          |          getInformation         |                                                   |
|:--------:|:-------------------------:|:-------------------------------------------------:|
|   Type   |          Variable         |                    Description                    |
| `Intent` |  `intent` | The current activitiy's intent. Used for getting information.  |

|          |      loadAboutScreen      |                                                   |
|:--------:|:-------------------------:|:-------------------------------------------------:|
|   Type   |          Variable         |                    Description                    |
| `Intent` |  `intent` | The about screen's intent. Used for presenting the about screen.  |

|          | setVisibility |                                                   |
|:--------:|:-------------------------:|:-------------------------------------------------:|
|   Type   |          Variable         |                    Description                    |
| `int` |  `visibilityValue` | The components visibility percentage.  |

|          | clickButtonNext |                                                   |
|:--------:|:-------------------------:|:-------------------------------------------------:|
|   Type   |          Variable         |                    Description                    |
| `Intent` |  `intent` | New intent used to open the desired screen.  |
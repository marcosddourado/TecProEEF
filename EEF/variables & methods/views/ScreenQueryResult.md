# ScreenStateList.java

##### &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;package com.mdsgpp.eef.views

## class ScreenStateList

#### Private members:

| Type     | Variable                     | Description                     |
|----------|------------------------------|---------------------------------|
| `TextView` | textViewInitials1 |  
| `TextView` | textViewName1 |
| `TextView` | textViewPopulation1 |
| `TextView` | textViewPopulationValue1 |
| `TextView` | textViewPibStateParticipation1 |
| `TextView` | textViewPibParticipation1 |
| `TextView` | textViewProjectNumber1 |
| `TextView` | textViewScienceTechnologyProjectCount1 |
| `TextView` | textViewValorScienceTechnologyProjects1 |
| `TextView` | textViewIdeb1 |
| `TextView` | textViewElementaryIdeb1 |
| `TextView` | textViewHighSchoolIdeb1 |
| `TextView` | textViewInitialSeriesIdeb1 |
| `TextView` | textViewFirstProjectsProgram1 |
| `TextView` | textViewFirstProjectsCount1 |
| `TextView` | textViewFirstProjectsValue1 |
| `TextView` | textViewResearchProjects1 |
| `TextView` | textViewResearchCount1 |
| `TextView` | textViewYoungResearchers1 |
| `TextView` | textViewYoungResearchersCount1 |
| `TextView` | textViewResearchValue1 |
| `TextView` | textViewYoungResearchersValue1 |
| `TextView` | textViewInitiationProjects1 |
| `TextView` | textViewInitiationProjectCount1 |
| `TextView` | textViewInitiationProjectValue1 |
| `TextView` | textViewCensus1 |
| `TextView` | textViewInitialSeriesCensus1 |
| `TextView` | textViewElementaryCensus1 |
| `TextView` | textViewHighSchoolCensus1 |
| `TextView` | textViewElementaryEjaCensus1 |
| `TextView` | textViewHighSchoolEjaCensus1 |
| `TextView` | textViewStudentsPerClass1 |
| `TextView` | textViewStudentsPerClassElementary1 |
| `TextView` | textViewStudentsPerClassHighSchool1 |
| `TextView` | textViewAverageClassTime1 |
| `TextView` | textViewClassTimeElementary1 |
| `TextView` | textViewClassTimeHighSchool1 |
| `TextView` | textViewDistortionRate1 |
| `TextView` | textViewDistortionRateElementary1 |
| `TextView` | textViewDistortionRateHighSchool1 |
| `TextView` | textViewUtilizationRate1 |
| `TextView` | textViewUtilizationRateElementary1 |
| `TextView` | textViewUtilizationRateHighSchool1 |
| `TextView` | textViewAbandonRate1 |
| `TextView` | textViewAbandonRateElementary1 |
| `TextView` | textViewAbandonRateHighSchool1 |
| `TextView` | textViewInitials2 |  
| `TextView` | textViewName2 |
| `TextView` | textViewPopulation2 |
| `TextView` | textViewPopulationValue2 |
| `TextView` | textViewPibStateParticipation2 |
| `TextView` | textViewPibParticipation2 |
| `TextView` | textViewProjectNumber2 |
| `TextView` | textViewScienceTechnologyProjectCount2 |
| `TextView` | textViewValorScienceTechnologyProjects2 |
| `TextView` | textViewIdeb2 |
| `TextView` | textViewElementaryIdeb2 |
| `TextView` | textViewHighSchoolIdeb2 |
| `TextView` | textViewInitialSeriesIdeb2 |
| `TextView` | textViewFirstProjectsProgram2 |
| `TextView` | textViewFirstProjectsCount2 |
| `TextView` | textViewFirstProjectsValue2 |
| `TextView` | textViewResearchProjects2 |
| `TextView` | textViewResearchCount2 |
| `TextView` | textViewYoungResearchers2 |
| `TextView` | textViewYoungResearchersCount2 |
| `TextView` | textViewResearchValue2 |
| `TextView` | textViewYoungResearchersValue2 |
| `TextView` | textViewInitiationProjects2 |
| `TextView` | textViewInitiationProjectCount2 |
| `TextView` | textViewInitiationProjectValue2 |
| `TextView` | textViewCensus2 |
| `TextView` | textViewInitialSeriesCensus2 |
| `TextView` | textViewElementaryCensus2 |
| `TextView` | textViewHighSchoolCensus2 |
| `TextView` | textViewElementaryEjaCensus2 |
| `TextView` | textViewHighSchoolEjaCensus2 |
| `TextView` | textViewStudentsPerClass2 |
| `TextView` | textViewStudentsPerClassElementary2 |
| `TextView` | textViewStudentsPerClassHighSchool2 |
| `TextView` | textViewAverageClassTime2 |
| `TextView` | textViewClassTimeElementary2 |
| `TextView` | textViewClassTimeHighSchool2 |
| `TextView` | textViewDistortionRate2 |
| `TextView` | textViewDistortionRateElementary2 |
| `TextView` | textViewDistortionRateHighSchool2 |
| `TextView` | textViewUtilizationRate2 |
| `TextView` | textViewUtilizationRateElementary2 |
| `TextView` | textViewUtilizationRateHighSchool2 |
| `TextView` | textViewAbandonRate2 |
| `TextView` | textViewAbandonRateElementary2 |
| `TextView` | textViewAbandonRateHighSchool2 |
| `boolean` | bCensus |
| `boolean` | bClassStudents |
| `boolean` | bClassTime |
| `boolean` | bDistortionRate |
| `boolean` | bAbandonRate |
| `boolean` | bApproval |
| `boolean` | bIdeb |
| `boolean` | bPib |
| `boolean` | bPopulation |
| `boolean` | bFirstProjects |
| `boolean` | bCnpqProjects |
| `boolean` | bDiffusionProjects |
| `boolean` | bInitiation |
| `boolean` | bYoungProjects |
| `ImageView` | imageViewFlag01 |
| `ImageView` | imageViewFlag02 |

| Return Type | Method Name |   Arguments   |   Description     |
|-------------|-------------|---------------|-------------------|
|   `void`    | captureInformation |        |  |
|   `void`    | fiilTextViews | `HashMap<String, String>` informations1, `HashMap<String, String>` informations2 | Fills the textViews with the given informations.  |
|   `void`    | initializeTextViews | | Initializes the text views. |

#### Protected members:

| Return Type | Method Name | Arguments | Description |
|:-----------:|:-----------:|:---------:|:-----------:|
|   `void`    |  onCreate   | `Bundle` savedInstanceState | Initializes the current activity. |

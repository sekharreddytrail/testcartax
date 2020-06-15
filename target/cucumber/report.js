$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("FirstFeature.feature");
formatter.feature({
  "line": 1,
  "name": "Automation test Practice website",
  "description": "",
  "id": "automation-test-practice-website",
  "keyword": "Feature"
});
formatter.before({
  "duration": 1592234400,
  "status": "passed"
});
formatter.scenario({
  "line": 3,
  "name": "Wiki search for String",
  "description": "",
  "id": "automation-test-practice-website;wiki-search-for-string",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "Navigate to website",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Read Inputfile and extract the Car Registration numbers and compare results",
  "keyword": "And "
});
formatter.match({
  "location": "homepagestepdefs.navigateToWebsite()"
});
formatter.result({
  "duration": 693148753,
  "status": "passed"
});
formatter.match({
  "location": "homepagestepdefs.readInputfileAndExtractTheCarRegistrationNumbersAndCompareResults()"
});
formatter.result({
  "duration": 34397522591,
  "status": "passed"
});
formatter.after({
  "duration": 91529256,
  "status": "passed"
});
});
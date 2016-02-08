# BingTranslator
BingTranslator
1.	Stored data in file transalate.csv and read values from there to run the tests.
2.	For UI testing for browsers IE, Chrome, Firefox Eclipse(Mars)/Selenium/Junit/Maven
3.	For API testing. Registered my application with Azure Market. Got a Secret code and client id. Got an appid to use the API.
4.	Used postman to get the appid and also test the api. , also used Soap UI and finally ended up using Eclipse Java Junit as they all will be same  project as UI testing. Used com.memetix.mst.language.Language and com.memetix.mst.translate.Translate;
5.	Checked in code to github. URL is 
6.	Can run the maven from command line with class name and test name.
7.	IE browser 11 seems to have problems on some tests. Preconditions:Tried setting registry value, enable protected mode is set to off in browser.
8.	I have not used all these technologies together in my home system and the latest version, so it was a challenge to install everything on home system and get it all to work.
9.	  Being open source it took me time to figure out everything on my own.
10.	
  Mvn  -Dtest=seleniumtranslatorTest#StartChromeWebDriver test
mvn -Dtest=seleniumtranslatorTest#StartFireFoxWebDriver test
mvn –Dtest=TranslatorAPITest#Bing_Translator test

package selenium_mvn;

import org.junit.Test;
	import com.memetix.mst.language.Language;
	import com.memetix.mst.translate.Translate;
	import com.csvreader.CsvReader;
	public class TranslatorAPITest{
		@Test
	  public void Bing_Translator() throws Exception {
			String translatedText;
		
			
			// Set your Windows Azure Marketplace client info - See http://msdn.microsoft.com/en-us/library/hh454950.aspx
	    Translate.setClientId("BingTranslator_Indra");
	    Translate.setClientSecret("G1604PD6u3iFEcptcGUoaWodN7hU23oaVfgkLzKVTEY=");
	  		CsvReader Reader = new CsvReader("Translate.csv");
		
	Reader.readHeaders();
		  //Text,To,From 
		while  (Reader.readRecord())
		{
			String TextToTrans = Reader.get("Text");

		String SrcLang = Reader.get("From");
		

		Language FromLang=Language.ARABIC;
		
		     
		     switch (SrcLang) {
		         case "French":
		        	 FromLang=Language.FRENCH;
		             break;
		         case "English":
		        	 FromLang=Language.ENGLISH;
		        	 break;
		         case "":
		        	 System.out.printf("No From Language\n");
		        	 FromLang=Language.ENGLISH;
		           	 break;
		         case "Spanish":
		        	 FromLang=Language.SPANISH;
		           	 break;   case "Japanese":
			        	 FromLang=Language.JAPANESE;
			           	 break;
		     }
		        	 
		     String DstLang = Reader.get("To");
				

				Language ToLang=Language.ARABIC;
				
				  switch (DstLang) {
			         case "French":
			        	 ToLang=Language.FRENCH;
			             break;
			         case "English":
			        	 ToLang=Language.ENGLISH;
			        	 break;
			         case "":
			        	 ToLang=Language.ENGLISH;
			        	 System.out.printf("No To Language");
			           	 break;
			         case "Spanish":
			        	 ToLang=Language.SPANISH;
			           	 break; 
			           	 case "Japanese":
			           		ToLang=Language.JAPANESE;
				           	 break;
			     }
			      
		   
			 translatedText = Translate.execute(TextToTrans, FromLang, ToLang);

			  System.out.printf(translatedText);
			  System.out.printf("\n");
	
		}
		 
		   Reader.close();
			  }
		}
import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
public class XMLExtractExample {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		File file = new File("/Users/voko02/eclipse-workspace/Temperature ConversionTesting/src/dataset.xml");
		DocumentBuilderFactory docBuilderFac = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docBuilderFac.newDocumentBuilder();
		Document doc = docBuilder.parse(file);
		doc.getDocumentElement().normalize();
		System.out.println(doc.getDocumentElement().getNodeName()); // To show the first line of XML file
		NodeList nodeList = doc.getElementsByTagName("case");
		System.out.println(nodeList.getLength());
		for(int n = 0; n < nodeList.getLength(); n++) { // retrieve cases from the XML
			Node node = nodeList.item(n);
			//System.out.println(node.toString());
			NodeList childNode = node.getChildNodes();
			for(int c = 0; c < childNode.getLength(); c++) { // retrieve columns inside each case
				Node tag = childNode.item(c);
				//System.out.println(tag.toString());
				String attr = tag.getNodeName();
				//System.out.println(attr);
				Element element = (Element) node;
				if(attr.equals("fahrenhiet")) {
					String value = element.getElementsByTagName(attr).item(0).getTextContent();
					System.out.println(attr + ": " + value);
				}
					else if(attr.equals("unit")) {
					String value = element.getElementsByTagName(attr).item(0).getTextContent();	
					System.out.println(attr + ": " + value);
					}
				}
			}
			
		}
	

}

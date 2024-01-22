package documentai;

import com.google.cloud.ServiceOptions;
import documentai.v1beta3.ProcessFormDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProcessMain {
    private static final Logger logger = LoggerFactory.getLogger(ProcessMain.class);
    public static void main(String[] args) {
        try {
            String projectId = ServiceOptions.getDefaultProjectId(); // get from Application Default Credentials
            String location = "us";//"your-project-location"; // Format is "us" or "eu".
            String processorId = "f45bf1a356e94e4c";//"your-processor-id";
            String filePath = "resources/multi_document.pdf";//"path/to/input/file.pdf";
            ProcessFormDocument.processFormDocument(
                    projectId, location, processorId, filePath);

            // Set up the Storage client
            // projectSet up the Storage client

            // Get the default project ID from the credentials
//            String projectId = ((GoogleCredentials) credentials).getQuotaProjectId();


            // Print the default project ID
            System.out.println("Default Project ID: " + projectId);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

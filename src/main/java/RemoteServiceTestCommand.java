import com.netflix.hystrix.HystrixCommand;


public class RemoteServiceTestCommand  extends HystrixCommand<String> {

    private RemoteServiceTestSimulator remoteService;

    RemoteServiceTestCommand(Setter config, RemoteServiceTestSimulator remoteService) {
        super(config);
        this.remoteService = remoteService;
    }

    @Override
    public String run() throws Exception {
        return remoteService.execute();
    }
}
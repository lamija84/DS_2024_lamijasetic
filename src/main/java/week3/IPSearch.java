package week3;

public class IPSearch {
    public static IPAddress search(IPAddress[] ipAddresses, String ipAddress) {

        long ipNumber = convert(ipAddress);
        int low = 0;
        int high = ipAddresses.length-1;

        while(low<=high){
            int mid = low + (high-low)/2;
            long start = ipAddresses[mid].getStartIp();
            long end = ipAddresses[mid].getEndIp();
            if(start<=ipNumber && ipNumber<=end){
                return ipAddresses[mid];
            }
            else if(ipNumber<end){
                high = mid - 1;
            }
            else if(ipNumber>end){
                low = mid + 1;
            }
        }

        return null;
    }

    public static long convert(String ipAddress){

        String[] splitAddress = ipAddress.split("\\.");

        long ipNumber =
                Long.parseLong(splitAddress[0])*16777216 +
                        Long.parseLong(splitAddress[1])*65536 +
                        Long.parseLong(splitAddress[2])*256 +
                        Long.parseLong(splitAddress[3]);

        return ipNumber;
    }
}

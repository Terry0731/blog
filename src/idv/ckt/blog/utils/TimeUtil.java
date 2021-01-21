package idv.ckt.blog.utils;

import java.sql.Timestamp;
import java.time.Instant;

public class TimeUtil {
	public static Timestamp getCurrTimestamp() {
		return Timestamp.from(Instant.now());
	}
}

package net.cheney.oakland.libc;

public class Fcntl {

	public static int 
		F_DUPFD = 0, /* duplicate file descriptor */
		F_GETFD = 1, /* get file descriptor flags */
		F_SETFD = 2, /* set file descriptor flags */
		F_GETFL = 3, /* get file status flags */
		F_SETFL = 4; /* set file status flags */
	
	public static int
		O_NONBLOCK = 0x0004,		/* no delay */
		O_APPEND = 0x0008,		/* set append mode */
		O_SYNC = 0x0080;		/* synchronous writes */
}

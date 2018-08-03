package com.xinlizz.oh.rock.exception;

import com.xinlizz.oh.rock.enums.RockErrorMsgEnum;

/**
 * RockException 异步任务异常类
 *
 * @Author: xinlizz
 * @Date: 2018/8/3
 */
public class RockException extends Exception {

    public RockException() {
    }

    public RockException(String message) {
        super(message);
    }

    public RockException(String message, Throwable cause) {
        super(message, cause);
    }

    public RockException(RockErrorMsgEnum rockErrorMsgEnum, Throwable cause) {
        super(rockErrorMsgEnum.getMessage(), cause);
    }
}

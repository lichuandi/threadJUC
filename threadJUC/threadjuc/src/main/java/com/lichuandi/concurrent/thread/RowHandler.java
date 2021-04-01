package com.lichuandi.concurrent.thread;

import java.sql.ResultSet;

public interface RowHandler<T>
{

    T handle(ResultSet rs);
}

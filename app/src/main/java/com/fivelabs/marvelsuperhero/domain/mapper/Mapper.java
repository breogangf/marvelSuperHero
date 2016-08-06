package com.fivelabs.marvelsuperhero.domain.mapper;

/**
 * Created by breogangf on 6/8/16.
 */
public interface Mapper<TFrom, TTo> {

  TTo map(TFrom from);
}

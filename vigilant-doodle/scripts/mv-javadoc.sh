#!/bin/bash

rsync -a ../dokumentaatio/checkstyle-raportti/apidocs/ ../dokumentaatio/javadoc/
rm -r ../dokumentaatio/checkstyle-raportti/apidocs

<h1>Android Proficiency Exercise<br /></h1>
Specification<br />
1.MVP  architectural pattern.<br />
2.This App Ingests a json feed from https://dl.dropboxusercontent.com/s/2iodh4vg0eortkl/facts.json <br />
3.The feed contains a title and a list of rows. <br />
4.Third party apis such as Retrofit, Gson and Picasso are used<br />
5.The content is displayed (including image, title and description) in a ListView <br />
6 The title in the ActionBar is updated from the json data. <br />
7.Each row should is dynamically sized to the right height to display its content - no clipping, no extraneous white-space etc. This means some rows will are larger than others.<br />
8.Loaded the images lazily (Used Picasso library for that).<br />
9.Implemented pull to refresh function allowing the data & view to be updated<br />
10.Non blocking UI while the data is being loaded.<br />

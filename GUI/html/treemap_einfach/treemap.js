var w = 960,
    h = 500,
    color = d3.scale.category20c();

var treemap = d3.layout.treemap()
    .size([w, h])
    .sticky(false)
    .value(function(d) { return d.size; });

var div = d3.select("#chart").append("div")
    .style("position", "relative")
    .style("width", w + "px")
    .style("height", h + "px");

d3.json("test.json", function(json) {
  div.data([json]).selectAll("div")
      .data(treemap.nodes,function(d){return d.name;})
    .enter().append("div")
      .attr("class", "cell")
      .style("background", function(d) { return d.children ? color(d.name) : null; })
      .call(cell)
      .text(function(d) { return d.children ? null : d.name; });

  d3.select("#size").on("click", function() {
    div.selectAll("div")
        .data(treemap.value(function(d) { return d.size; }))
      .transition()
        .duration(1500)
        .call(cell);

    d3.select("#size").classed("active", true);
    d3.select("#count").classed("active", false);
  });
  
  var counter=10;
  
  d3.select("#add").on("click", function() {
       var newElem  =
       {
        "name" : counter,
            "children": [
                {
                    "size": "37", 
                    "other_size": "497", 
                    "name": counter+".1"
                }
            ]
       };
       counter+=1;
      json.children.push(newElem);
                
      div.data([json]).selectAll("div")
      .data(treemap.nodes,function(d){return d.name;})
      .enter().append("div")
      .attr("class", "cell")
      .style("background", function(d) { return d.children ? color(d.name) : null; })
      .call(cell)
      .text(function(d) { return d.children ? null : d.name; });
  });

  d3.select("#count").on("click", function() {
  
    div.selectAll("div")
        .data(treemap.value(function(d) { return d.other_size; }))
      .transition()
        .duration(1500)
        .call(cell);


    d3.select("#size").classed("active", false);
    d3.select("#count").classed("active", true);
  });
});

function cell() {
  this
      .style("left", function(d) { return d.x + "px"; })
      .style("top", function(d) { return d.y + "px"; })
      .style("width", function(d) { return d.dx - 1 + "px"; })
      .style("height", function(d) { return d.dy - 1 + "px"; });
}
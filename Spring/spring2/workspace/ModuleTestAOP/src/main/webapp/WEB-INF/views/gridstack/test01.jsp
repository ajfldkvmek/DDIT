<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath }/resources/gridstack/dist/gridstack.min.css" rel="stylesheet"/>
<!-- <link rel="stylesheet" href="/resources/gridstack/dist/demo.css" /> -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="${pageContext.request.contextPath }/resources/gridstack/dist/gridstack-all.js"></script>
<style type="text/css">
  .grid-stack { background: #FAFAD2; }
  .grid-stack-item-content { background-color: #18BC9C; }
</style>
</head>
<body>


<div class="row">
    <div class="col-md-2 d-none d-md-block">
      <div id="trash" style="padding: 5px; margin-bottom: 15px;" class="text-center">
        <div>
          <ion-icon name="trash" style="font-size: 300%"></ion-icon>
        </div>
        <div>
          <span>Drop here to remove!</span>
        </div>
      </div>
      <div class="newWidget grid-stack-item">
        <div class="grid-stack-item-content" style="padding: 5px;">
          <div>
            <ion-icon name="add-circle" style="font-size: 300%"></ion-icon>
          </div>
          <div>
            <span>Drag me in the dashboard!</span>
          </div>
        </div>
      </div>
    </div>
    <div class="col-sm-12 col-md-10">
      <div class="grid-stack"></div>
    </div>
  </div>



<script type="text/javascript">
let grid = GridStack.init({
    cellHeight: 70,
    acceptWidgets: true,
    removable: '#trash', // drag-out delete class
  });
  GridStack.setupDragIn('.newWidget', { appendTo: 'body', helper: 'clone' });

  let items = [
    {x: 0, y: 0, w: 4, h: 2, content: '1'},
    {x: 4, y: 0, w: 4, h: 4, noMove: true, noResize: true, locked: true, content: 'I can\'t be moved or dragged!<br><ion-icon name="ios-lock" style="font-size:300%"></ion-icon>'},
    {x: 8, y: 0, w: 2, h: 2, minW: 2, noResize: true, content: '<p class="card-text text-center" style="margin-bottom: 0">Drag me!<p class="card-text text-center"style="margin-bottom: 0"><ion-icon name="hand" style="font-size: 300%"></ion-icon><p class="card-text text-center" style="margin-bottom: 0">...but don\'t resize me!'},
    {x: 10, y: 0, w: 2, h: 2, content: '4'},
    {x: 0, y: 2, w: 2, h: 2, content: '5'},
    {x: 2, y: 2, w: 2, h: 4, content: '6'},
    {x: 8, y: 2, w: 4, h: 2, content: '7'},
    {x: 0, y: 4, w: 2, h: 2, content: '8'},
    {x: 4, y: 4, w: 4, h: 2, content: '9'},
    {x: 8, y: 4, w: 2, h: 2, content: '10'},
    {x: 10, y: 4, w: 2, h: 2, content: '11'},
  ];
  grid.load(items);
  
  grid.on('added removed change', function(e, items) {
    let str = '';
    items.forEach(function(item) { str += ' (x,y)=' + item.x + ',' + item.y; });
    console.log(e.type + ' ' + items.length + ' items:' + str );
  });
</script>

</body>
</html>
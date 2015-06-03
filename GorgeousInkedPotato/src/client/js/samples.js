var t1Displayed = false;
var t2Displayed = false;
var t3Displayed = false;

function displayT1S1() {
	iframe = document.getElementsByName('samples')[0];
	iframe.src="http://jorisrat.me/pad/app/samples/tree1/sample1.txt";
	//iframe.style.display="block";
}

function displayT1S2() {
	iframe = document.getElementsByName('samples')[0];
	iframe.src="http://jorisrat.me/pad/app/samples/tree1/sample2.txt";
	//iframe.style.display="block";
}

function displayT2S1() {
	iframe = document.getElementsByName('samples')[0];
	iframe.src="http://jorisrat.me/pad/app/samples/tree2/sample1.txt";
	//iframe.style.display="block";
}

function displayT2S2() {
	iframe = document.getElementsByName('samples')[0];
	iframe.src="http://jorisrat.me/pad/app/samples/tree2/sample2.txt";
	//iframe.style.display="block";
}

function displayT3S1() {
	iframe = document.getElementsByName('samples')[0];
	iframe.src="http://jorisrat.me/pad/app/samples/tree3/sample1.txt";
	//iframe.style.display="block";
}

function displayT3S2() {
	iframe = document.getElementsByName('samples')[0];
	iframe.src="http://jorisrat.me/pad/app/samples/tree3/sample2.txt";
	//iframe.style.display="block";
}

function toggleDisplayT1() {
	li1 = document.getElementById('t1s1');
	li2 = document.getElementById('t1s2');
	input = document.getElementById('tree1');
	if(t1Displayed == false) {
		li1.innerHTML = '<input type="button" value="sample 1" class="file" onclick="displayT1S1();"/>';
		li2.innerHTML = '<input type="button" value="sample 2" class="file" onclick="displayT1S2();"/>';
		input.value = 'v';
		t1Displayed = true;
	} else {
		li1.innerHTML = '';
		li2.innerHTML = '';
		input.value = '>';
		t1Displayed = false;
	}
}

function toggleDisplayT2() {
	li1 = document.getElementById('t2s1');
	li2 = document.getElementById('t2s2');
	input = document.getElementById('tree2');
	if(t2Displayed == false) {
		li1.innerHTML = '<input type="button" value="sample 1" class="file" onclick="displayT2S1();"/>';
		li2.innerHTML = '<input type="button" value="sample 2" class="file" onclick="displayT2S2();"/>';
		input.value = 'v';
		t2Displayed = true;
	} else {
		li1.innerHTML = '';
		li2.innerHTML = '';
		input.value = '>';
		t2Displayed = false;
	}
}

function toggleDisplayT3() {
	li1 = document.getElementById('t3s1');
	li2 = document.getElementById('t3s2');
	input = document.getElementById('tree3');
	if(t3Displayed == false) {
		li1.innerHTML = '<input type="button" value="sample 1" class="file" onclick="displayT3S1();"/>';
		li2.innerHTML = '<input type="button" value="sample 2" class="file" onclick="displayT3S2();"/>';
		input.value = 'v';
		t3Displayed = true;
	} else {
		li1.innerHTML = '';
		li2.innerHTML = '';
		input.value = '>';
		t3Displayed = false;
	}
}
